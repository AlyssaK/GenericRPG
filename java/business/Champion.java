package business;

import java.io.Serializable;
import static java.lang.Math.pow;
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
@Table(name="champion")
public class Champion implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;  
    
    @Column(name="accountID")
    private int accountID;
    
    @Column(name="exp")
    private double exp;
    
    @Transient
    private double expAtNext;
    
    @Column(name="totalExp")
    private double totalExp;
    
    @Transient
    private double totalExpAtNext;
    
    @Column(name="beginner_wins")
    private int beg_wins;
    
    @Column(name="beginner_losses")
    private int beg_losses;
    
    @Column(name="apprentice_wins")
    private int app_wins;
    
    @Column(name="apprentice_losses")
    private int app_losses;
    
    @Column(name="master_wins")
    private int master_wins;
    
    @Column(name="master_losses")
    private int master_losses;
    
    @Column(name="boss_wins")    
    private int boss_wins;
    
    @Column(name="boss_losses")
    private int boss_losses;
    
    @Column(name="name")
    private String name;
    
    @Column(name="strength")
    private int strength;
    
    @Column(name="accuracy")
    private int accuracy;
    
    @Column(name="speed")
    private int speed;
    
    @Column(name="skill")
    private int skill;
    
    @Column(name="knowledge")
    private int knowledge;
    
    @Column(name="levelz")
    private int levelz;
    
    @Transient
    private int healthPoints;
    @Transient
    private double baseHitPercent;
    @Transient
    private double baseCritPercent;
    @Transient
    private double baseDodgePercent;
    @Transient
    private int baseDmgReduct;
    @Transient
    private int baseCritDmgBonus;
    @Transient
    private int baseDmg;
    @Transient
    private Move move1;
    @Transient
    private Move move2;
    @Transient
    private Move move3;
    @Transient 
    private Move move4;
    
    @Column(name="moveID1")
    private int moveID1;
    
    @Column(name="moveID2")
    private int moveID2;
    
    @Column(name="moveID3")
    private int moveID3;
    
    @Column(name="moveID4")
    private int moveID4;
    
    @Column(name="portrait")
    private String portrait;
    
    //Empty Constructor
    public Champion(){
        this.accountID = 0;
        this.exp = 0.0;
        this.expAtNext = 0.0;
        this.totalExp = 0.0;
        this.totalExpAtNext = 0.0;
        this.beg_wins = 0;
        this.beg_losses = 0;
        this.app_wins = 0;
        this.app_losses = 0;
        this.master_wins = 0;
        this.master_losses = 0;
        this.boss_wins = 0;
        this.boss_losses = 0;
        this.name = "";
        this.strength = 0;
        this.accuracy = 0;
        this.speed= 0;
        this.skill = 0;
        this.knowledge = 0;
        this.levelz = 0;
        this.moveID1 = 0;
        this.moveID2 = 0;
        this.moveID3 = 0;
        this.moveID4 = 0;        
        this.portrait = "";
    }
    
    //Create New Character Constructor
    public Champion(int aid, String n, int st, int ac, int sp, int sk,
            int kn, int ai1, int ai2, int ai3, int ai4, String pl){ 
        this.accountID = aid;
        this.exp = 0.0;
        this.expAtNext = 0.0;
        this.totalExp = 0.0;
        this.totalExpAtNext = 0.0;
        this.beg_wins = 0;
        this.beg_losses = 0;
        this.app_wins = 0;
        this.app_losses = 0;
        this.master_wins = 0;
        this.master_losses = 0;
        this.boss_wins = 0;
        this.boss_losses = 0;
        this.name = n;
        this.strength = st;
        this.accuracy = ac;
        this.speed= sp;
        this.skill = sk;
        this.knowledge = kn;
        this.levelz = 1;
        this.portrait = pl;
        this.moveID1 = ai1;
        this.moveID2 = ai2;
        this.moveID3 = ai3;
        this.moveID4 = ai4;          
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    
    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public double getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(double totalExp) {
        this.totalExp = totalExp;
    }   

    public int getBeg_wins() {
        return beg_wins;
    }

    public void setBeg_wins(int beg_wins) {
        this.beg_wins = beg_wins;
    }

    public int getBeg_losses() {
        return beg_losses;
    }

    public void setBeg_losses(int beg_losses) {
        this.beg_losses = beg_losses;
    }

    public int getApp_wins() {
        return app_wins;
    }

    public void setApp_wins(int app_wins) {
        this.app_wins = app_wins;
    }

    public int getApp_losses() {
        return app_losses;
    }

    public void setApp_losses(int app_losses) {
        this.app_losses = app_losses;
    }

    public int getMaster_wins() {
        return master_wins;
    }

    public void setMaster_wins(int master_wins) {
        this.master_wins = master_wins;
    }

    public int getMaster_losses() {
        return master_losses;
    }

    public void setMaster_losses(int master_losses) {
        this.master_losses = master_losses;
    }

    public int getBoss_wins() {
        return boss_wins;
    }

    public void setBoss_wins(int boss_wins) {
        this.boss_wins = boss_wins;
    }

    public int getBoss_losses() {
        return boss_losses;
    }

    public void setBoss_losses(int boss_losses) {
        this.boss_losses = boss_losses;
    }

    public double getExpAtNext() {
        return expAtNext;
    }

    public void setExpAtNext(double expAtNext) {
        this.expAtNext = expAtNext;
    }

    public double getTotalExpAtNext() {
        return totalExpAtNext;
    }

    public void setTotalExpAtNext(double totalExpAtNext) {
        this.totalExpAtNext = totalExpAtNext;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public int getLevelz() {
        return levelz;
    }

    public void setLevelz(int levelz) {
        this.levelz = levelz;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public double getBaseHitPercent() {
        return baseHitPercent;
    }

    public void setBaseHitPercent(double baseHitPercent) {
        this.baseHitPercent = baseHitPercent;
    }

    public double getBaseCritPercent() {
        return baseCritPercent;
    }

    public void setBaseCritPercent(double baseCritPercent) {
        this.baseCritPercent = baseCritPercent;
    }

    public double getBaseDodgePercent() {
        return baseDodgePercent;
    }

    public void setBaseDodgePercent(double baseDodgePercent) {
        this.baseDodgePercent = baseDodgePercent;
    }

    public int getBaseDmgReduct() {
        return baseDmgReduct;
    }

    public void setBaseDmgReduct(int baseDmgReduct) {
        this.baseDmgReduct = baseDmgReduct;
    }

    public int getBaseCritDmgBonus() {
        return baseCritDmgBonus;
    }

    public void setBaseCritDmgBonus(int baseCritDmgBonus) {
        this.baseCritDmgBonus = baseCritDmgBonus;
    }

    public int getBaseDmg() {
        return baseDmg;
    }

    public void setBaseDmg(int baseDmg) {
        this.baseDmg = baseDmg;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
    
    public void buildCombatant(){
        calcHealthPoints();
        calcBaseHitPercent();
        calcBaseDodgePercent();
        calcBaseCritPercent();
        calcBaseCritDmgBonus();
        calcBaseDmg();
        calcBaseDmgReduct();                
    }
    
    public final void calcHealthPoints(){
        int hp;
        
        int lvl_mod = this.getLevelz() * 250;
        int str_mod = this.strength * 10;
        int kno_mod = this.knowledge * 5;
        
        hp = lvl_mod + str_mod + kno_mod;
        
        this.setHealthPoints(hp);
    }
    
    public final void calcBaseHitPercent(){
        double hit = 85.00;
        double hit_cap = 100.00;
        
        double acc_mod = this.accuracy * pow(this.accuracy, -.5);
        double skl_mod = this.skill * pow(this.skill, -.6);
        double kno_mod = this.knowledge * pow (this.knowledge, -.7);
        
        hit += acc_mod + skl_mod + kno_mod;
        
        if(hit > hit_cap){
            hit = hit_cap;
        }
        
        this.setBaseHitPercent(hit);
    }
    public final void calcBaseCritPercent(){
        double crit = 0.0;
        double crit_cap = 75.0;
        
        double skl_mod = this.skill * pow(this.skill, -.5);
        double kno_mod = this.knowledge * pow(this.knowledge, -.5);
        double spd_mod = this.speed * pow(this.speed, -.7);
        double str_mod = this.strength * pow(this.strength, -.8);
        
        crit += str_mod + skl_mod + kno_mod + spd_mod + str_mod;
        
        if(crit > crit_cap){
            crit = crit_cap;
        }
        
        this.setBaseCritPercent(crit);
    }
    
    public final void calcBaseDodgePercent(){
        double dodge = 2.50;
        double dodge_cap = 32.50;
        
        double spd_mod = this.speed * pow(this.speed, -.6);
        double skl_mod = this.skill * pow(this.skill, -.7);
        double kno_mod = this.knowledge * pow(this.knowledge, -.8);
        
        dodge += spd_mod + skl_mod + kno_mod;
        
        if(dodge > dodge_cap){
            dodge = dodge_cap;
        }
        
        this.setBaseDodgePercent(dodge);
    }
    public final void calcBaseCritDmgBonus(){
        int critDMG = 5;
        
        double str_mod = this.strength * 3;
        double kno_mod = (this.knowledge * 3)/2;
        double skl_mod = (this.skill * 3)/2;
        
        critDMG += (int) (str_mod + kno_mod + skl_mod); 
        
        this.setBaseCritDmgBonus(critDMG);
    }
    public final void calcBaseDmg(){
        int dmg = 5;
        
        double str_mod = this.strength * 3;
        double acc_mod = (this.accuracy * 3)/2;
        double skl_mod = (this.skill* 5)/4;
        double spd_mod = (this.speed * 5)/4;
        double kno_mod = (this.knowledge * 7)/6;
        
        dmg += (int) (str_mod + acc_mod + skl_mod + spd_mod + kno_mod);
        
        this.setBaseDmg(dmg);
    }
    public final void calcBaseDmgReduct(){
        int red;
         
        double spd_mod = this.speed * 2;
        double skl_mod = (this.skill * 7)/3;
        double str_mod = (this.strength * 4)/3;
        double kno_mod = (this.knowledge * 5)/4;
        
        red = (int) (spd_mod + skl_mod + str_mod + kno_mod);
        
        this.setBaseDmgReduct(red);
    }

    public int getMoveID1() {
        return moveID1;
    }

    public void setMoveID1(int moveID1) {
        this.moveID1 = moveID1;
    }

    public int getMoveID2() {
        return moveID2;
    }

    public void setMoveID2(int moveID2) {
        this.moveID2 = moveID2;
    }

    public int getMoveID3() {
        return moveID3;
    }

    public void setMoveID3(int moveID3) {
        this.moveID3 = moveID3;
    }

    public int getMoveID4() {
        return moveID4;
    }

    public void setMoveID4(int moveID4) {
        this.moveID4 = moveID4;
    }

    public Move getMove1() {
        return move1;
    }

    public void setMove1(Move move1) {
        this.move1 = move1;
    }

    public Move getMove2() {
        return move2;
    }

    public void setMove2(Move move2) {
        this.move2 = move2;
    }

    public Move getMove3() {
        return move3;
    }

    public void setMove3(Move move3) {
        this.move3 = move3;
    }

    public Move getMove4() {
        return move4;
    }

    public void setMove4(Move move4) {
        this.move4 = move4;
    }
}
