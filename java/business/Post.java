/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Alyssa
 */
@Entity
@Table(name = "post")
public class Post implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="accountID")
    private int accountID;
    
    @Column(name="accountName")
    private String accountName;
    
    @Column(name="postDate")
    @Temporal(TemporalType.DATE)
    private Date postDate;
    
    @Column(name="text")
    private String text;
    
    public Post(){
        this.id = 0;
        this.accountID = 0;
        this.accountName = "";
        this.text = "";
        this.postDate = null;
    }
    
    public Post(String t, int aid, String n){
        this.accountID = aid;
        this.accountName = n;
        this.text = t;
    }
    
    public void setCurrentDate(){
        this.postDate = new Date(Calendar.getInstance().getTime().getTime());  
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPostDate() {
        return this.postDate;
    }

    public void setDate(Date date) {
        this.postDate = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
