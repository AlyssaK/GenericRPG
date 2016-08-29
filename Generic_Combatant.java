/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import static java.lang.Math.pow;
import java.util.ArrayList;

/**
 *
 * @author Alyssa
 */
public class Generic_Combatant {
    private int id;
    private String name;
    private int str;
    private int acc;
    private int speed;
    private int skill;
    private int know;
    private int level;
    private int healthPoints;
    private double baseHitPercent;
    private double baseCritPercent;
    private double baseDodgePercent;
    private int baseDmgReduct;
    private int baseCritDmgBonus;
    private int baseDmg;
    private ArrayList<Action> charActions;
    private String photo_loc;
    
    public Generic_Combatant(){
        this.id = -1;
        this.name = "";
        this.str = 0;
        this.acc = 0;
        this.speed= 0;
        this.skill = 0;
        this.know = 0;
        this.level = 0;
        this.healthPoints = 0;
        this.baseHitPercent = 0.0;
        this.baseCritPercent = 0.0;
        this.baseDodgePercent = 0.0;
        this.baseDmgReduct = 0;
        this.baseCritDmgBonus = 0;
        this.baseDmg = 0;
        this.charActions = new ArrayList<>();
        this.photo_loc = "";
    }
    
    //Create New Character Constructor
    public Generic_Combatant(String n, int st, int ac, int sp, int sk,
            int kn, String pl){
        this.id = 0;
        this.name = n;
        this.str = st;
        this.acc = ac;
        this.speed= sp;
        this.skill = sk;
        this.know = kn;
        this.level = 1;
        this.photo_loc = pl;
        calcHealthPoints();
        calcBaseHitPercent();
        calcBaseCritPercent();
        calcBaseDodgePercent();
        calcBaseDmgReduct();
        calcBaseCritDmgBonus();
        calcBaseDmg();
        this.charActions = new ArrayList<>();
    }
    
    //Load Existing Character Constructor
    public Generic_Combatant(int id, String n, int st, int ac, int sp, int sk,
            int kn, int lvl, String pl){
        this.id = id;
        this.name = n;
        this.str = st;
        this.acc = ac;
        this.speed= sp;
        this.skill = sk;
        this.know = kn;
        this.level = lvl;   
        this.photo_loc = pl;
        calcHealthPoints();
        calcBaseHitPercent();
        calcBaseCritPercent();
        calcBaseDodgePercent();
        calcBaseDmgReduct();
        calcBaseCritDmgBonus();
        calcBaseDmg();
        this.charActions = new ArrayList<>();        
    }
    
     public void reCalcAllStats(){
        calcBaseHitPercent();
        calcBaseCritPercent();
        calcBaseCritDmgBonus();
        calcBaseDmg();
        calcBaseDmgReduct();
    }
    
    public final void calcHealthPoints(){
        int hp;
        
        int lvl_mod = this.getLevel() * 250;
        int str_mod = this.getStr() * 10;
        int kno_mod = this.getKnow() * 5;
        
        hp = lvl_mod + str_mod + kno_mod;
        
        this.setHealthPoints(hp);
    }
    
    public final void calcBaseHitPercent(){
        double hit = 88.50;
        double hit_cap = 98.75;
        
        double acc_mod = this.getAcc() * pow(this.getAcc(), -.75);
        double skl_mod = this.getSkill() * pow(this.getSkill(), -.90);
        double kno_mod = this.getKnow() * pow (this.getKnow(), -.95);
        
        hit += acc_mod + skl_mod + kno_mod;
        
        if(hit > hit_cap){
            hit = hit_cap;
        }
        
        this.setBaseHitPercent(hit);
    }
    public final void calcBaseCritPercent(){
        double crit = 25.0;
        double crit_cap = 75.0;
        
        double skl_mod = this.getSkill() * pow(this.getSkill(), -.59);
        double kno_mod = this.getKnow() * pow(this.getKnow(), -.66);
        double spd_mod = this.getSpeed() * pow(this.getSpeed(), -.78);
        double str_mod = this.getStr() * pow(this.getStr(), -.93);
        
        crit += str_mod + skl_mod + kno_mod + spd_mod + str_mod;
        
        if(crit > crit_cap){
            crit = crit_cap;
        }
        
        this.setBaseCritPercent(crit);
    } 
    public final void calcBaseDodgePercent(){
        double dodge = 2.50;
        double dodge_cap = 32.50;
        
        double spd_mod = this.getSpeed() * pow(this.getSpeed(), -.73);
        double skl_mod = this.getSkill() * pow(this.getSkill(), -.77);
        double kno_mod = this.getKnow() * pow(this.getKnow(), -.89);
        
        dodge += spd_mod + skl_mod + kno_mod;
        
        if(dodge > dodge_cap){
            dodge = dodge_cap;
        }
        
        this.setBaseDodgePercent(dodge);
    }
    public final void calcBaseCritDmgBonus(){
        int critDMG = 5;
        
        double str_mod = this.getStr() * 3;
        double kno_mod = (this.getKnow() * 3)/2;
        double skl_mod = (this.getSkill() * 3)/2;
        
        critDMG += (int) (str_mod + kno_mod + skl_mod); 
        
        this.setBaseCritDmgBonus(critDMG);
    }
    public final void calcBaseDmg(){
        int dmg = 5;
        
        double str_mod = this.getStr() * 3;
        double acc_mod = (this.getAcc() * 3)/2;
        double skl_mod = (this.getSkill() * 5)/4;
        double spd_mod = (this.getSpeed() * 5)/4;
        double kno_mod = (this.getKnow() * 7)/6;
        
        dmg += (int) (str_mod + acc_mod + skl_mod + spd_mod + kno_mod);
        
        this.setBaseDmg(dmg);
    }
    public final void calcBaseDmgReduct(){
        int red;
        
        double spd_mod = this.getSpeed() * 2;
        double skl_mod = (this.getSkill() * 7)/3;
        double str_mod = (this.getStr() * 4)/3;
        double kno_mod = (this.getKnow() * 5)/4;
        
        red = (int) (spd_mod + skl_mod + str_mod + kno_mod);
        
        this.setBaseDmgReduct(red);
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

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
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

    public int getKnow() {
        return know;
    }

    public void setKnow(int know) {
        this.know = know;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public ArrayList<Action> getCharActions() {
        return charActions;
    }

    public void setCharActions(ArrayList<Action> charActions) {
        this.charActions = charActions;
    }

    public String getPhoto_loc() {
        return photo_loc;
    }

    public void setPhoto_loc(String photo_loc) {
        this.photo_loc = photo_loc;
    }
    
}
