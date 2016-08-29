package business;

import java.util.Random;

/**
 *
 * @author Alyssa
 */
public class Battle {
    private Champion player;
    private Opponent computer;
    private Action player_curr_move;
    private Action comp_curr_move;
    private String difficulty_level;
      
    private int player_curr_hp;
    private int comp_curr_hp;
    
    private boolean turn; //False = Comp :: True = Player
    private int winner; //-1 = Comp Win :: 0 = Undecided :: 1 = Player Win
    
    //Empty Constructor
    public Battle(){
        this.player = new Champion();
        this.computer = new Opponent();
        this.player_curr_move = new Action();
        this.comp_curr_move = new Action();
        
        this.player_curr_hp = 0;
        this.comp_curr_hp = 0;
        
        this.turn = false;
        this.winner = 0;
    }
    
    //Initiate New Battle Constructor
    public Battle(Champion p, Opponent c){
        this.player = p;
        this.computer = c;
        this.player_curr_move = new Action();
        this.comp_curr_move = new Action();
        
        this.player_curr_hp = this.player.getHealthPoints();
        this.comp_curr_hp =  this.computer.getHealthPoints();
        
        this.turn = this.player.getSpeed() >= this.computer.getSpeed();
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

    public int getPlayer_curr_hp() {
        return player_curr_hp;
    }

    public void setPlayer_curr_hp(int player_curr_hp) {
        this.player_curr_hp = player_curr_hp;
    }

    public int getComp_curr_hp() {
        return comp_curr_hp;
    }

    public void setComp_curr_hp(int comp_curr_hp) {
        this.comp_curr_hp = comp_curr_hp;
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
    
    public boolean doesHit(){
        Random rand = new Random();
        int randInt = rand.nextInt(10000);
               
        if(turn){
            double plyr_hitpercent = player.getBaseHitPercent() + ((player.getBaseHitPercent() * player_curr_move.getBaseHitChance())/100);
            int comp_active_dodge = (int) (computer.getBaseDodgePercent() * 100);
            int hitInt = (int) (plyr_hitpercent * 100);
            int chance = hitInt - comp_active_dodge;
            return chance>=randInt;
        }else{
            double comp_hitpercent = computer.getBaseHitPercent() + ((computer.getBaseHitPercent() * comp_curr_move.getBaseHitChance())/100);
            int plyr_active_dodge = (int) (player.getBaseDodgePercent() * 100);
            int hitInt = (int) (comp_hitpercent * 100);
            int chance = hitInt - plyr_active_dodge;
            return chance>=randInt;
        }
    }
    
    public boolean doesCrit(){
        Random rand = new Random();
        int randInt = rand.nextInt(10000);
        
        if(turn){
            int critChance = (int) (player.getBaseCritPercent() * 100);
            return critChance >= randInt;
        }else{
            int critChance = (int) (computer.getBaseCritPercent() * 100);
            return critChance >=  randInt;
        }
    }
    
    public int DamageDone(){
        int TotalDMG;
        
        if(turn){
            TotalDMG = player.getBaseDmg() + player_curr_move.getBaseDMG();
            if(doesCrit()){
                TotalDMG += player.getBaseCritDmgBonus();
            }
           TotalDMG -= computer.getBaseDmgReduct();
        }else{
            TotalDMG = computer.getBaseDmg() + comp_curr_move.getBaseDMG();
            if(doesCrit()){
                TotalDMG += computer.getBaseCritDmgBonus();
            }
           TotalDMG -= player.getBaseDmgReduct();
        }
        
        return TotalDMG;
    }
    
    public int HealsDone(){
        int TotalHeals;
        
        if(turn){
            TotalHeals = player_curr_move.getBaseHEAL();
        }else{
            TotalHeals = comp_curr_move.getBaseHEAL();
        }
        
        return TotalHeals;
    }

    public Action getPlayer_curr_move() {
        return player_curr_move;
    }

    public void setPlayer_curr_move(Action player_curr_move) {
        this.player_curr_move = player_curr_move;
    }

    public Action getComp_curr_move() {
        return comp_curr_move;
    }

    public void setComp_curr_move(Action comp_curr_move) {
        this.comp_curr_move = comp_curr_move;
    }
    
    public void isAlterApplyAlter(){
        if(turn){
            if(player_curr_move.getAlterSTR()>0){
                player.setStr(player.getStr()+player_curr_move.getAlterSTR());              
            }
            if(player_curr_move.getAlterSPD()>0){
                player.setSpeed(player.getSpeed()+player_curr_move.getAlterSPD());
            }
            if(player_curr_move.getAlterSKL()>0){
                player.setSkill(player.getSkill()+player_curr_move.getAlterSKL());
            }
            if(player_curr_move.getAlterACC()>0){
                player.setAcc(player.getAcc()+player_curr_move.getAlterACC());
            }
            if(player_curr_move.getAlterKNO()>0){
                player.setStr(player.getStr()+player_curr_move.getAlterSTR());
            }
            player.reCalcAllStats();
        }else{
            if(comp_curr_move.getAlterSTR()>0){
                computer.setStr(computer.getStr()+comp_curr_move.getAlterSTR());              
            }
            if(comp_curr_move.getAlterSPD()>0){
                computer.setSpeed(computer.getSpeed()+comp_curr_move.getAlterSPD());
            }
            if(comp_curr_move.getAlterSKL()>0){
                computer.setSkill(computer.getSkill()+comp_curr_move.getAlterSKL());
            }
            if(comp_curr_move.getAlterACC()>0){
                computer.setAcc(computer.getAcc()+comp_curr_move.getAlterACC());
            }
            if(comp_curr_move.getAlterKNO()>0){
                computer.setStr(computer.getStr()+comp_curr_move.getAlterSTR());
            }
            computer.reCalcAllStats();
        }
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public String getDifficulty_level() {
        return difficulty_level;
    }

    public void setDifficulty_level(String difficulty_level) {
        this.difficulty_level = difficulty_level;
    }
    
    
    
    
    
}
