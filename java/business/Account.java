package business;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "account")
public class Account implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "accountID")
    private int accountID;
    
    @Column(name = "accountName")
    private String name;
    
    @Column(name = "accountPassword")
    private String password;
    
    @Transient
    private String pwdAttempt;
    
    @Column(name = "accountEmail")
    private String email;
    
    @Column(name = "accountActiveChampID")
    private int activeChampID;
    
    @Transient
    private Champion activeChamp;
    
    @Column(name = "accountPrivileges")
    private int privileges;
    
    @Column(name = "accountOnline")
    private boolean online;
    
    @Column(name = "accountExp")
    private double exp;
    
    @Transient
    private double expAtNext; 
    
    @Column(name = "accountTotalExp")
    private double totalExp;
    
    @Transient
    private double totalExpAtNext;  
    
    @Column(name = "accountLevel")
    private int level;
   
    @Transient
    private List<Champion> champions;
    
    @Transient
    private List<Post> posts;
    
    public Account(){
        this.name = "";
        this.password = "";
        this.pwdAttempt = "";
        this.email = "None Provided";
        this.exp = 0;
        this.expAtNext = 0;
        this.totalExp = 0;
        this.totalExpAtNext = 0;
        this.level = 1;
        this.privileges = 0;
        this.accountID = 0;
        this.activeChampID = 0;
        this.online = false;
        this.champions = null;
        this.posts = null;
    }
    
    public Account(String nm, String pw, String pwd, String email){
        this.name = nm;
        this.password = pw;
        this.pwdAttempt = pwd;
        this.email = email;
        this.exp = 0;
        this.expAtNext = 0;
        this.totalExp = 0;
        this.totalExpAtNext = 0;
        this.level = 1;
        this.privileges = 0;
        this.accountID = 0;
        this.activeChampID = 0;
        this.online = false;
        this.champions = null;
        this.posts = null;
        this.activeChamp = null;
    }
   
    public boolean isAccountAuthen() {
        if(!this.password.isEmpty()){
            if(this.password.equals(this.pwdAttempt)){
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
    public List<Champion> getChampions() {
        return champions;
    }
    public void setChampions(List<Champion> champions) {
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isOnline() {
        return online;
    }
    public void setOnline(boolean online) {
        this.online = online;
    }
    public double getExp(){
        return this.exp;
    }    
    public void setExp(double exp) {
        this.exp = exp;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getPrivileges() {
        return privileges;
    }
    public void setPrivileges(int privileges) {
        this.privileges = privileges;
    }
    public List<Post> getPosts() {
        return posts;
    }
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    public double getExpAtNext() {
        return expAtNext;
    }
    public void setExpAtNext(double expAtNext) {
        this.expAtNext = expAtNext;
    }
    public double getTotalExp() {
        return totalExp;
    }
    public void setTotalExp(double totalExp) {
        this.totalExp = totalExp;
    }
    public double getTotalExpAtNext() {
        return totalExpAtNext;
    }
    public void setTotalExpAtNext(double totalExpAtNext) {
        this.totalExpAtNext = totalExpAtNext;
    }
}
