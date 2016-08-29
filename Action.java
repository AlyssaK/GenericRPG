package business;
/**
 *
 * @author Alyssa
 */
public class Action {
    private String actionID;
    private String actionName;
    private int alterSTR;
    private int alterACC;
    private int alterSPD;
    private int alterSKL;
    private int alterKNO;
    private int baseDMG;
    private int baseHEAL;
    private double baseHitChance;
    
    public Action(){
        this.actionID = "";
        this.actionName = "";
        this.alterSTR = 0;
        this.alterACC = 0;
        this.alterSPD = 0;
        this.alterSKL = 0;
        this.alterKNO = 0;
        this.baseDMG = 0;
        this.baseHEAL = 0;
        this.baseHitChance = 0.0;
    }

    public String getActionID() {
        return actionID;
    }

    public void setActionID(String actionID) {
        this.actionID = actionID;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
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
}
