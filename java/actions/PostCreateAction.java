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
public class PostCreateAction extends ActionSupport implements SessionAware {
    
    private Map session;
    private Account account;
    private String text;
    
    public PostCreateAction() { }
    
    @Override
    public String execute() throws Exception {
        Map request = (Map) ActionContext.getContext().get("request");
        String rval;
        String msg = "";
        Post p;
        
        this.account = (Account) this.session.get("account"); 
        p = new Post(this.getText(), this.account.getAccountID(), this.account.getName());
        p.setCurrentDate();
        
        try{
            msg += PostDB.addNewPost(p);            
        }catch(Exception e){
            msg += "Error: " + e.getMessage();
        }
        
        if(!msg.startsWith("Error")){
            this.account.setPosts(PostDB.loadPosts(this.account.getAccountID()));
            this.session.put("account", account);
            msg += "Post Successfully Added!";
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
