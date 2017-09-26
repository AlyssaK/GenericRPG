/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.*;
import business.Champion;
import business.ChampionDB;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Alyssa
 */
public class ChampionCreateAction extends ActionSupport implements SessionAware {
    
    private Map session;
    private Account account;
    private String name;
    private String strength;
    private String accuracy;
    private String skill;
    private String knowledge;
    private String speed;
    private String portrait;
    
    public ChampionCreateAction() {}
    
    @Override
    public void validate(){
        int total = 0;
        int max = 25;
        
        if(!ChampionDB.checkChampionName(this.name)){
            addFieldError("name", "Name Already Taken!");
        }
        try{
            int str = Integer.parseInt(this.strength);
            int acc = Integer.parseInt(this.accuracy);
            int spd = Integer.parseInt(this.speed);
            int skl = Integer.parseInt(this.skill);
            int know = Integer.parseInt(this.knowledge);
            
            total = str + acc + spd + skl + know;
            
            if( total != max){
               addFieldError("strength", "Doesn't add up to 25"); 
            }            
        }catch(NumberFormatException e){
            addFieldError("strength", "Not A Number Between 0 & 25: " + e.getMessage());
        }
        
    }
    
    @Override
    public String execute() throws Exception { 
        Map request = (Map) ActionContext.getContext().get("request");
        String rval;
        String msg = "";
        
        this.account = (Account) this.session.get("account");
        
        int str = Integer.parseInt(this.strength);
        int acc = Integer.parseInt(this.accuracy);
        int spd = Integer.parseInt(this.speed);
        int skl = Integer.parseInt(this.skill);
        int know = Integer.parseInt(this.knowledge);
        
        Champion c = new Champion(this.account.getAccountID(), this.name, str, acc, spd, skl, know, 
                1,2,3,4, this.portrait);
        c.buildCombatant();
        
        try{              
            msg += ChampionDB.addNewChampion(c); 
            this.account.setChampions(ChampionDB.loadChampions(this.account.getAccountID()));
        }catch(Exception e){
            msg += "Error: " + e.getMessage();
        }
        
        if(!msg.startsWith("Error")){
            this.session.put("account", account);
            rval = SUCCESS;
        }else{
            rval = INPUT;
        }
        
        request.put("msg", msg);
        return rval;
    }
    
    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
    
}
