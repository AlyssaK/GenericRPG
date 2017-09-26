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

/**
 *
 * @author Alyssa
 */
public class AccountCreateAction extends ActionSupport {
    
    private Account account;
    private String acct_name;
    private String password1;
    private String password2;
    private String email;
        
    public AccountCreateAction() {}
    
    @Override
    public void validate(){
        if(!AccountDB.checkAccountName(this.getAcct_name())){
            addFieldError("acct_name", "Name Already Taken!");
        }
        if(!this.password1.equals(this.password2)){
            addFieldError("password2", "Passwords Do Not Match!");
        }
        
    }
    
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        String rval = INPUT;
        String msg = "";
        
        this.account = new Account(this.acct_name, this.password1, this.password2, this.email);
        msg = AccountDB.addNewAccount(this.account);
        
        if(!msg.startsWith("Error")){
            rval = SUCCESS;
        }
        
        request.put("msg", msg);
        return rval;
    }

    public String getAcct_name() {
        return acct_name;
    }

    public void setAcct_name(String acct_name) {
        this.acct_name = acct_name;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
