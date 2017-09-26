package business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Alyssa
 */
@Entity
@Table(name = "move")
public class Move implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="strength")
    private int alterSTR;
    
    @Column(name="accuracy")
    private int alterACC;
    
    @Column(name="speed")
    private int alterSPD;
    
    @Column(name="skill")
    private int alterSKL;
    
    @Column(name="knowledge")
    private int alterKNO;
    
    @Column(name="damage")
    private int baseDMG;
    
    @Column(name="healz")
    private int baseHEAL;
    
    @Column(name="hitChance")
    private double baseHitChance;
    
    public Move(){
        this.id = 0;
        this.name = "";
        this.alterSTR = 0;
        this.alterACC = 0;
        this.alterSPD = 0;
        this.alterSKL = 0;
        this.alterKNO = 0;
        this.baseDMG = 0;
        this.baseHEAL = 0;
        this.baseHitChance = 0.0;
    }
    
    public Move(String nm, int str, int acc, int spd, int skl, int know, int dmg, int heal, double bhc){
        this.name = nm;
        this.alterSTR = str;
        this.alterACC = acc;
        this.alterSPD = spd;
        this.alterSKL = skl;
        this.alterKNO = know;
        this.baseDMG = dmg;
        this.baseHEAL = heal;
        this.baseHitChance = bhc;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlterSTR() {
        return alterSTR;
    }

    public void setAlterSTR(int alterSTR) {
        this.alterSTR = alterSTR;
    }

    public int getAlterACC() {
        return alterACC;
    }

    public void setAlterACC(int alterACC) {
        this.alterACC = alterACC;
    }

    public int getAlterSPD() {
        return alterSPD;
    }

    public void setAlterSPD(int alterSPD) {
        this.alterSPD = alterSPD;
    }

    public int getAlterSKL() {
        return alterSKL;
    }

    public void setAlterSKL(int alterSKL) {
        this.alterSKL = alterSKL;
    }

    public int getAlterKNO() {
        return alterKNO;
    }

    public void setAlterKNO(int alterKNO) {
        this.alterKNO = alterKNO;
    }

    public int getBaseDMG() {
        return baseDMG;
    }

    public void setBaseDMG(int baseDMG) {
        this.baseDMG = baseDMG;
    }

    public int getBaseHEAL() {
        return baseHEAL;
    }

    public void setBaseHEAL(int baseHEAL) {
        this.baseHEAL = baseHEAL;
    }

    public double getBaseHitChance() {
        return baseHitChance;
    }

    public void setBaseHitChance(double baseHitChance) {
        this.baseHitChance = baseHitChance;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
