package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Alyssa
 */

@Entity
@Table(name="battle")
public class Battle implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "turnID")
    private int turnID;
    
    @Column(name = "battleID")
    private int battleID;
    
    @Column(name = "accountID")
    private int accountID;
    
    @Column(name = "championID")
    private int championID;
    
    @Column(name = "opponentID")
    private int opponentID;
    
    @Column(name = "difficultyLevel")
    private String diffLevel;
    
    @Column(name = "playerMove")
    private int pMoveID;
    
    @Column(name = "compMove")
    private int cMoveID; 
    
    @Column(name = "playerHP")
    private int playerHP;
    
    @Column(name = "compHP")
    private int compHP;
    
    @Column(name = "playerDMG")
    private int playerDMG;
    
    @Column(name = "compDMG")      
    private int compDMG;
    
    @Column(name = "playerHeal")
    private int playerHeal;
    
     @Column(name = "compHeal")
    private int compHeal;
    
    @Column(name = "playerHit")
    private boolean playerHit;
    
    @Column(name = "compHit")
    private boolean compHit;
    
    @Column(name = "playerCrit")
    private boolean playerCrit;
    
    @Column(name = "compCrit")
    private boolean compCrit;
    
    @Transient
    private Champion player;
    @Transient
    private Opponent computer;
    
    @Transient 
    private ArrayList<Move> playerMoves;
    @Transient 
    private ArrayList<Move> compMoves;
    
    @Transient
    private Move playerMove;
    @Transient
    private Move compMove;   
    
    @Transient
    private boolean turn; //False = Comp :: True = Player
    @Transient
    private int winner; //-1 = Comp Win :: 0 = Undecided :: 1 = Player Win
    
    //Empty Constructor
    public Battle(){
        this.battleID = 0;
        this.accountID = 0;
        this.championID = 0;
        this.opponentID = 0;
        
        this.cMoveID = 0;
        this.pMoveID = 0;

        this.diffLevel = "";
        
        this.compDMG = 0;
        this.playerDMG = 0;
        this.playerHP = 0;
        this.compHP = 0;
        this.compCrit = false;
        this.compHit = false;
        this.playerCrit = false;
        this.compCrit = false;        
        
        this.player = null;
        this.computer = null;
        
        this.playerMoves = null;
        this.compMoves =  null;
        this.playerMove = null;
        this.compMove = null;        
        
        this.turn = false;
        this.winner = 0;
    }
    
    //Initiate New Battle Constructor
    public Battle(int bid, Account a, Champion p, Opponent c, int pHP, int cHP, ArrayList<Move> pm, ArrayList<Move> cm, String d, boolean turn){
        this.battleID = bid;
        this.turnID = 0;
        
        this.player = p;
        this.computer = c; 
        this.playerMoves = pm;
        this.compMoves = cm;
        
        this.accountID = a.getAccountID();
        this.championID = p.getId();
        this.opponentID = c.getId();
        
        this.diffLevel = d;

        this.compDMG = 0;
        this.playerDMG = 0;
        this.compCrit = false;
        this.compHit = false;
        this.playerCrit = false;
        this.compCrit = false;
        
        this.playerHP = pHP;
        this.compHP =  cHP;
        
        this.turn = turn;
        this.winner = 0;
    }

    public Champion getPlayer() {
        return player;
    }

    public void setPlayer(Champion player) {
        this.player = player;
    }

    public Opponent getComputer() {
        return computer;
    }

    public void setComputer(Opponent computer) {
        this.computer = computer;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }    

    public boolean firstStrike(){
        setTurn(this.player.getSpeed() >= this.computer.getSpeed());
        return this.turn;
    }
    
    public int getPlayerHit(){              
        int chance = (int) ((this.player.getBaseHitPercent() + this.getPlayerMove().getBaseHitChance())/2);
            chance -= (int) this.computer.getBaseDodgePercent();
        return chance;
    }    
    public int getComputerHit(){       
        int chance = (int) ((this.computer.getBaseHitPercent() + this.getCompMove().getBaseHitChance())/2);
            chance -= (int) this.player.getBaseDodgePercent();
        return chance;
    }    
    
    public int getPlayerCrit(){
        int critChance = (int) (player.getBaseCritPercent());
        return critChance;        
    }
    public int getComputerCrit(){
        int critChance = (int) (computer.getBaseCritPercent());
        return critChance;
    }
    
    public int getDamageDone(){
        int TotalDMG;
        
        if(turn){
            TotalDMG = player.getBaseDmg() + getPlayerMove().getBaseDMG();
            TotalDMG -= computer.getBaseDmgReduct();
        }else{
            TotalDMG = computer.getBaseDmg() + getCompMove().getBaseDMG();            
            TotalDMG -= player.getBaseDmgReduct();
        }
        
        return TotalDMG;
    }
    
    public int getHealsDone(){
        int TotalHeals;
        
        if(turn){
            TotalHeals = getPlayerMove().getBaseHEAL();
        }else{
            TotalHeals = getCompMove().getBaseHEAL();
        }
        
        return TotalHeals;
    }
    
    public void applyAlter(Move m){        
        if(m.getAlterSTR()>0){
            computer.setStrength(computer.getStrength() + (m.getAlterSTR() * computer.getLevelz()));              
        }
        if(m.getAlterSPD()>0){
            computer.setSpeed(computer.getSpeed() + (m.getAlterSPD() * computer.getLevelz()));
        }
        if(m.getAlterSKL()>0){
            computer.setSkill(computer.getSkill() + (m.getAlterSKL() * computer.getLevelz()));
        }
        if(m.getAlterACC()>0){
            computer.setAccuracy(computer.getAccuracy() + (m.getAlterACC() * computer.getLevelz()));
        }
        if(m.getAlterKNO()>0){
            computer.setStrength(computer.getStrength() + (m.getAlterSTR() * computer.getLevelz()));
        }
        computer.buildCombatant();
    } 

    
    public void removeAlter(Move m){
        if(m.getAlterSTR()>0){
            player.setStrength(player.getStrength() - (m.getAlterSTR()* player.getLevelz()));              
        }
        if(m.getAlterSPD()>0){
            player.setSpeed(player.getSpeed() - (m.getAlterSPD()* player.getLevelz()));
        }
        if(m.getAlterSKL()>0){
            player.setSkill(player.getSkill() - (m.getAlterSKL() * player.getLevelz()));
        }
        if(m.getAlterACC()>0){
            player.setAccuracy(player.getAccuracy() - (m.getAlterACC() * player.getLevelz()));
        }
        if(m.getAlterKNO()>0){
            player.setStrength(player.getStrength() - (m.getAlterSTR()* player.getLevelz()));
        }
        player.buildCombatant();        
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public int getTurnID() {
        return turnID;
    }

    public void setTurnID(int turnID) {
        this.turnID = turnID;
    }

    public int getBattleID() {
        return battleID;
    }

    public void setBattleID(int battleID) {
        this.battleID = battleID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getChampionID() {
        return championID;
    }

    public void setChampionID(int championID) {
        this.championID = championID;
    }

    public int getOpponentID() {
        return opponentID;
    }

    public void setOpponentID(int opponentID) {
        this.opponentID = opponentID;
    }

    public int getpMoveID() {
        return pMoveID;
    }

    public void setpMoveID(int pMoveID) {
        this.pMoveID = pMoveID;
    }

    public int getcMoveID() {
        return cMoveID;
    }

    public void setcMoveID(int cMoveID) {
        this.cMoveID = cMoveID;
    }

    public int getPlayerHP() {
        return playerHP;
    }

    public void setPlayerHP(int playerHP) {
        this.playerHP = playerHP;
    }

    public int getCompHP() {
        return compHP;
    }

    public void setCompHP(int compHP) {
        this.compHP = compHP;
    }

    public int getPlayerDMG() {
        return playerDMG;
    }

    public void setPlayerDMG(int playerDMG) {
        this.playerDMG = playerDMG;
    }

    public int getCompDMG() {
        return compDMG;
    }

    public void setCompDMG(int compDMG) {
        this.compDMG = compDMG;
    }

    public int getPlayerHeal() {
        return playerHeal;
    }

    public void setPlayerHeal(int playerHeal) {
        this.playerHeal = playerHeal;
    }

    public int getCompHeal() {
        return compHeal;
    }

    public void setCompHeal(int compHeal) {
        this.compHeal = compHeal;
    }

    public boolean isPlayerHit() {
        return playerHit;
    }

    public void setPlayerHit(boolean playerHit) {
        this.playerHit = playerHit;
    }

    public boolean isCompHit() {
        return compHit;
    }

    public void setCompHit(boolean compHit) {
        this.compHit = compHit;
    }

    public boolean isPlayerCrit() {
        return playerCrit;
    }

    public void setPlayerCrit(boolean playerCrit) {
        this.playerCrit = playerCrit;
    }

    public boolean isCompCrit() {
        return compCrit;
    }

    public void setCompCrit(boolean compCrit) {
        this.compCrit = compCrit;
    }

    public Move getPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(Move playerMove) {
        this.playerMove = playerMove;
    }

    public Move getCompMove() {
        return compMove;
    }

    public void setCompMove(Move compMove) {
        this.compMove = compMove;
    }

    public String getDiffLevel() {
        return diffLevel;
    }

    public void setDiffLevel(String diffLevel) {
        this.diffLevel = diffLevel;
    }

    public ArrayList<Move> getPlayerMoves() {
        return playerMoves;
    }

    public void setPlayerMoves(ArrayList<Move> playerMoves) {
        this.playerMoves = playerMoves;
    }

    public ArrayList<Move> getCompMoves() {
        return compMoves;
    }

    public void setCompMoves(ArrayList<Move> compMoves) {
        this.compMoves = compMoves;
    }
}
