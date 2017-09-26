/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.*;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Alyssa
 */
public class AccountLoginAction extends ActionSupport implements SessionAware{
    
    private Map session;
    private Account account;
    private List<Move> moves;
    private List<XPChart> XPChart;
    private String acct_name;
    private String pattempt;
    
    public String getAcct_name(){
        return this.acct_name;
    }
    public void setAcct_name(String an){
        this.acct_name = an;
    }
    
    public String getPattempt(){
        return this.pattempt;
    }
    public void setPattempt(String pa){
        this.pattempt = pa;
    }
    
    @Override
    public void setSession(Map session) {
        this.session = session;
    }
    
    public AccountLoginAction() {
    }
    
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        
        String rval;
        String msg = "";
        
        this.account = AccountDB.getAccount(this.acct_name);
        this.moves = MoveDB.loadMoves(); 
        if(this.moves != null) {
            this.session.put("moves", this.moves);
            msg += "Actions Loaded! <br>";
        }else{
            msg += "Error Loading Actions!<br>";
        }
        
        this.XPChart = XPChartDB.loadXPChart();
        if(this.XPChart != null){
            this.session.put("XPChart", this.XPChart);
            msg += "XPChart Loaded!<br>";            
        }else{
            msg += "Error Loading XPChart!<br>";
        }
        
        if(this.account != null){
            this.account.setPwdAttempt(this.pattempt);                        

            if(this.account.isAccountAuthen()){ 
                
                this.account.setTotalExpAtNext(this.XPChart.get(this.account.getLevel()).getAccountTotalXP());
                this.account.setExpAtNext(this.XPChart.get(this.account.getLevel()).getAccountXPtoNext());                
                this.account.setChampions(ChampionDB.loadChampions(this.account.getAccountID()));
                if(this.account.getChampions() != null){
                    msg = this.account.getChampions().stream().map((ch) -> {
                        ch.buildCombatant();
                        return ch;
                    }).map((ch) -> {
                        ch.setExpAtNext(this.XPChart.get(ch.getLevelz()).getChampXPtoNext());
                        return ch;
                    }).map((ch) -> {
                        ch.setTotalExpAtNext(this.XPChart.get(ch.getLevelz()).getChampTotalXP());
                        return ch;
                    }).filter((ch) -> (ch.getId() == this.account.getActiveChampID())).map((ch) -> {
                        this.account.setActiveChamp(ch);
                        return ch;
                    }).map((_item) -> this.account.getActiveChamp().getName() + " is your Active Champion!<br>").reduce(msg, String::concat);
                    
                    this.account.getChampions().forEach((c) -> {
                        this.moves.stream().map((m) -> {
                            if(c.getMoveID1() == m.getId()){
                                c.setMove1(m);
                            }
                            return m;
                        }).map((m) -> {
                            if(c.getMoveID2() == m.getId()){
                                c.setMove2(m);
                            }
                            return m;
                        }).map((m) -> {
                            if(c.getMoveID3() == m.getId()){
                                c.setMove3(m);
                            }
                            return m;
                        }).filter((m) -> (c.getMoveID4() == m.getId())).forEachOrdered((m) -> {
                            c.setMove4(m);
                        });
                    });
                    
                    msg += this.account.getChampions().size() + " Champions Loaded!<br>";
                }else{
                    msg += "Error Loading Champions!<br>";
                }
                
                this.account.setPosts(PostDB.loadPosts(this.account.getAccountID()));
                if(this.account.getPosts() != null){
                    msg += this.account.getPosts().size() + " Posts Loaded!<br>";
                }else{
                    msg += "Error Loading Posts!<br>";
                }
                
                this.account.setOnline(true);
                this.session.put("account", this.account);                
                
                msg += "Login Successful!<br>";
                rval = SUCCESS; 
            }else{
                msg = "Login Failed!";
                rval = INPUT;
            }     
        }else{
            msg = "Data Retrieval Error!";
            rval = INPUT;
        }       
        
        request.put("msg", msg);
        
        return rval;    
    }
    
}
