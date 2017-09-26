/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.Battle;
import business.Champion;
import business.Move;
import business.Opponent;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Alyssa
 */
public class TurnBattleAction extends ActionSupport {
    
    private Map session;
    private boolean action1;
    private boolean action2;
    private boolean action3;
    private boolean action4;
    
    public TurnBattleAction() {
        
    }
    
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        String rval;
        String msg = "";
        Random rand = new Random();
        
        int randAction = rand.nextInt(4);
        int chosenAction = 0;
        int cActionID;
        int rActionID;
        Move cAction;
        Move rAction;
        
        Battle battle = (Battle) this.session.get("battle");
        Champion player = battle.getPlayer();
        Opponent computer = battle.getComputer();
        
        player.buildCombatant();
        computer.buildCombatant();
       
        if(action1){
            chosenAction = 0;
        }else if(action2){
            chosenAction = 1;            
        }else if(action3){
            chosenAction = 2;
        }else if(action4){
            chosenAction = 3;
        }
        
        cActionID = battle.getPlayerMoves().get(chosenAction).getId();
        cAction = battle.getPlayerMoves().get(chosenAction);
        battle.setPlayerMove(cAction);
        battle.setpMoveID(cActionID);
        
        rActionID = battle.getCompMoves().get(randAction).getId();
        rAction = battle.getPlayerMoves().get(randAction);
        battle.setCompMove(rAction);
        battle.setcMoveID(rActionID);
        
        
        
        
        rval = SUCCESS;
        
        return rval;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public void setAction1(boolean action1) {
        this.action1 = action1;
    }

    public void setAction2(boolean action2) {
        this.action2 = action2;
    }

    public void setAction3(boolean action3) {
        this.action3 = action3;
    }

    public void setAction4(boolean action4) {
        this.action4 = action4;
    }
    
}
