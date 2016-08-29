package business;

import java.util.ArrayList;

/**
 *
 * @author Alyssa
 */
public class Account {
    private String name;
    private String password;
    private String pwdAttempt;
    private double account_exp;
    private double account_total_exp;
    private int account_level;
    private int accountID;
    private int activeChampID;
    private ArrayList<Champion> champions;
    private Champion activeChamp;
    
    public Account(){
        this.name = "";
        this.password = "";
        this.pwdAttempt = "";
        this.account_exp = 0;
        this.account_total_exp = 0;
        this.account_level = 1;
        this.accountID = 0;
        this.activeChampID = 0;
        this.champions = new ArrayList<>();
        this.activeChamp = new Champion();
    }
    
    public boolean isAccountAuthen() {
        if(!this.password.isEmpty()){
            if(this.password.equalsIgnoreCase(this.pwdAttempt)){
                return true;
            }
        }        
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPwdAttempt() {
        return pwdAttempt;
    }

    public void setPwdAttempt(String pwdAttempt) {
        this.pwdAttempt = pwdAttempt;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public ArrayList<Champion> getChampions() {
        return champions;
    }

    public void setChampions(ArrayList<Champion> champions) {
        this.champions = champions;
    }

    public Champion getActiveChamp() {
        return activeChamp;
    }

    public void setActiveChamp(Champion activeChamp) {
        this.activeChamp = activeChamp;
    }

    public int getActiveChampID() {
        return activeChampID;
    }

    public void setActiveChampID(int activeChampID) {
        this.activeChampID = activeChampID;
    }

    public double getAccount_exp() {
        return account_exp;
    }

    public void setAccount_exp(double account_exp) {
        this.account_exp = account_exp;
    }

    public double getAccount_total_exp() {
        return account_total_exp;
    }

    public void setAccount_total_exp(double account_total_exp) {
        this.account_total_exp = account_total_exp;
    }

    public int getAccount_level() {
        return account_level;
    }

    public void setAccount_level(int account_level) {
        this.account_level = account_level;
    }
}
