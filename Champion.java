package business;

import static java.lang.Math.pow;
import java.util.ArrayList;

/**
 *
 * @author Alyssa
 */

public class Champion extends Generic_Combatant{
    private int accountID;
    private double exp;
    private double totalExp;
    private int beg_wins, beg_losses;
    private int app_wins, app_losses;
    private int master_wins, master_losses;
    private int boss_wins, boss_losses;
    
    //Empty Constructor
    public Champion(){
        super();
        this.accountID = 0;
        this.exp = 0;
        this.totalExp = 0;
        this.beg_wins = 0;
        this.beg_losses = 0;
        this.app_wins = 0;
        this.app_losses = 0;
        this.master_wins = 0;
        this.master_losses = 0;
        this.boss_wins = 0;
        this.boss_losses = 0;
    }
    
    //Create New Character Constructor
    public Champion(int aid, String n, int st, int ac, int sp, int sk,
            int kn, String pl){
        super(n, st, ac, sp, sk, kn, pl);
        this.accountID = aid;
        this.exp = 0;
        this.totalExp = 0;
        this.beg_wins = 0;
        this.beg_losses = 0;
        this.app_wins = 0;
        this.app_losses = 0;
        this.master_wins = 0;
        this.master_losses = 0;
        this.boss_wins = 0;
        this.boss_losses = 0;
    }
    
    //Load Existing Character Constructor
    public Champion(int id, int aid, String n, int st, int ac, int sp, int sk,
            int kn, int lvl, long xp, long txp, String pl, int bw, int bl, int aw,
            int al, int mw, int ml, int bsw, int bsl){
        super(id, n, st, ac, sp, sk, kn, lvl, pl);
        this.accountID = aid;        
        this.exp = xp;
        this.totalExp = txp;        
        this.beg_wins = bw;
        this.beg_losses = bl;
        this.app_wins = aw;
        this.app_losses = al;
        this.master_wins = mw;
        this.master_losses = ml;
        this.boss_wins = bsw;
        this.boss_losses = bsl;    
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
}
