package business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Alyssa
 */

@Entity
@Table(name = "xpchart")
public class XPChart implements Serializable {
    
    @Id
    @Column(name="theLevel")
    private int level;
    
    @Column(name="accountXP2Next")
    private long accountXPtoNext;
    
    @Column(name="champXP2Next")
    private long champXPtoNext;
    
    @Column(name="beginner")
    private double beginner;
    
    @Column(name="apprentice")
    private double apprentice;
    
    @Column(name="master")
    private double master;
    
    @Column(name="boss")
    private double boss;
    
    @Column(name="accountTotalXP")
    private long accountTotalXP;
    
    @Column(name="champTotalXP")
    private long champTotalXP;
    
    public XPChart() {
        this.level = 0;
        this.accountXPtoNext = 0;
        this.champXPtoNext = 0;
        this.beginner = 0.0;
        this.apprentice = 0.0;
        this.master = 0.0;
        this.boss = 0.0;
        this.accountTotalXP = 0;
        this.champTotalXP = 0;        
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getAccountXPtoNext() {
        return accountXPtoNext;
    }

    public void setAccountXPtoNext(long accountXPtoNext) {
        this.accountXPtoNext = accountXPtoNext;
    }

    public long getChampXPtoNext() {
        return champXPtoNext;
    }

    public void setChampXPtoNext(long champXPtoNext) {
        this.champXPtoNext = champXPtoNext;
    }

    public double getBeginner() {
        return beginner;
    }

    public void setBeginner(double beginner) {
        this.beginner = beginner;
    }

    public double getApprentice() {
        return apprentice;
    }

    public void setApprentice(double apprentice) {
        this.apprentice = apprentice;
    }

    public double getMaster() {
        return master;
    }

    public void setMaster(double master) {
        this.master = master;
    }

    public double getBoss() {
        return boss;
    }

    public void setBoss(double boss) {
        this.boss = boss;
    }

    public long getAccountTotalXP() {
        return accountTotalXP;
    }

    public void setAccountTotalXP(long accountTotalXP) {
        this.accountTotalXP = accountTotalXP;
    }

    public long getChampTotalXP() {
        return champTotalXP;
    }

    public void setChampTotalXP(long champTotalXP) {
        this.champTotalXP = champTotalXP;
    }
    
}
