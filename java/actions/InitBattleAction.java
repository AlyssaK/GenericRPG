
package actions;

import business.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Alyssa
 */
public class InitBattleAction extends ActionSupport implements SessionAware {
    
    private String difficulty;
    private String active;
    private Map session;
    private Account account;
    private ArrayList<Move> moves;
        
    public InitBattleAction() { }
    
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        String rval;
        String msg = "";
        Random rand = new Random();
        Opponent opponent = null;
        Champion champion = null;
        ArrayList<Move> playerMoves = null;
        ArrayList<Move> compMoves = null;
        
        Battle battle;
        
        this.moves = (ArrayList<Move>) this.session.get("moves");
        this.account = (Account) this.session.get("account");
                
        int activeID = Integer.parseInt(this.active);       
        int oppID = rand.nextInt(41) + 1;
        
        try{ 
            champion = ChampionDB.getChampionByID(activeID);
            champion.buildCombatant();
            playerMoves.add(champion.getMove1());
            playerMoves.add(champion.getMove2());
            playerMoves.add(champion.getMove3());
            playerMoves.add(champion.getMove4());
            this.account.setActiveChamp(champion);
            opponent = OpponentDB.findOpponent(oppID);            
            opponent.buildCombatant();
            for(Move m : this.moves){
                if(m.getId() == opponent.getActionID1()){
                    compMoves.set(0, m);
                }else if(m.getId() == opponent.getActionID2()){
                    compMoves.set(1, m);
                }else if(m.getId() == opponent.getActionID3()){
                    compMoves.set(2, m);
                }else if(m.getId() == opponent.getActionID4()){
                    compMoves.set(3, m);
                }
            }
        }catch(Exception e){
            msg += "Error Loading Fighters: " + e.getMessage();
        }
        
        if(champion !=null && opponent != null){
            int battleID = BattleDB.getBattleID();
            int playerHP = champion.getHealthPoints();
            int compHP = opponent.getHealthPoints();
            boolean turn= champion.getSpeed() >= opponent.getSpeed();
            battle = new Battle(battleID, this.account, champion, opponent, playerHP, compHP, playerMoves, compMoves, this.difficulty, turn);
            BattleDB.addNewBattleTurn(battle);
            this.session.put("battle", battle);
            msg += "Battle Loaded!";
            rval= SUCCESS;
        }else{
            rval = INPUT;
        }
        
        request.put("msg", msg);
               
        return rval;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
    
}
