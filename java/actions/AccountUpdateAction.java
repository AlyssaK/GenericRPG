/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Alyssa
 */
public class AccountUpdateAction extends ActionSupport implements SessionAware{
    
    private Map session;
    private Account account;    
    
    public Account getAccount(){
        return this.account;
    }
    
    public void setAccount(Account account){
        this.account = account;
    }
    
    @Override
    public void setSession(Map session) {
        this.session = session;
    }
    
    public AccountUpdateAction() { }
    
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        String msg = AccountDB.syncAccount(this.account);
        
        if(!msg.startsWith("Error")){
            this.account = AccountDB.getAccount(this.account.getName());
            this.session.put("account", this.account);           
        }else{
            return INPUT;
        }        
        
        request.put("msg", msg);
        return SUCCESS;
    }
    
}
