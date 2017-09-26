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
@Table(name = "opponent")
public class Opponent implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;  
    
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
    
    @Column(name="difficulty")
    private String difficulty;
    
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
    
    @Column(name="actionID1")
    private int actionID1;
    
    @Column(name="actionID2")
    private int actionID2;
    
    @Column(name="actionID3")
    private int actionID3;
    
    @Column(name="actionID4")
    private int actionID4;
    
    @Column(name="portrait")
    private String portrait;
    
    public Opponent(){
        this.id = -1;
        this.name = "";
        this.strength = 0;
        this.accuracy = 0;
        this.speed= 0;
        this.skill = 0;
        this.knowledge = 0;
        this.levelz = 0;
        this.healthPoints = 0;
        this.baseHitPercent = 0.0;
        this.baseCritPercent = 0.0;
        this.baseDodgePercent = 0.0;
        this.baseDmgReduct = 0;
        this.baseCritDmgBonus = 0;
        this.baseDmg = 0;
        this.actionID1 = 0;
        this.actionID2 = 0;
        this.actionID3 = 0;
        this.actionID4 = 0;
        this.portrait = "";
        this.difficulty = "";       
    }    
   
    public Opponent(int id, String n, int st, int ac, int sp, int sk, int kn, int lvl,
            int ai1, int ai2, int ai3, int ai4, String dl, String pl){
        this.id = id;
        this.name = n;
        this.strength = st;
        this.accuracy = ac;
        this.speed= sp;
        this.skill = sk;
        this.knowledge = kn;
        this.healthPoints = 0;
        this.baseHitPercent = 0.0;
        this.baseCritPercent = 0.0;
        this.baseDodgePercent = 0.0;
        this.baseDmgReduct = 0;
        this.baseCritDmgBonus = 0;
        this.baseDmg = 0;
        this.levelz = lvl;   
        this.portrait = pl;
        this.actionID1 = ai1;
        this.actionID2 = ai2;
        this.actionID3 = ai3;
        this.actionID4 = ai4;        
        this.difficulty = dl;
        
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String diff_level) {
        this.difficulty = diff_level;
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

    public int getActionID1() {
        return actionID1;
    }

    public void setActionID1(int actionID1) {
        this.actionID1 = actionID1;
    }

    public int getActionID2() {
        return actionID2;
    }

    public void setActionID2(int actionID2) {
        this.actionID2 = actionID2;
    }

    public int getActionID3() {
        return actionID3;
    }

    public void setActionID3(int actionID3) {
        this.actionID3 = actionID3;
    }

    public int getActionID4() {
        return actionID4;
    }

    public void setActionID4(int actionID4) {
        this.actionID4 = actionID4;
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
}