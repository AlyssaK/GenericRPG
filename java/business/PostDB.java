/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Alyssa
 */
public class PostDB {
    
    public static List<Post> loadPosts(int aid){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        List<Post> posts = null;
        
        try{
            String qS = "FROM Post p WHERE p.accountID = :aid";
            session = sessionFactory.openSession();
            Query q = session.createQuery(qS);
            q.setParameter("aid", aid);
            posts = q.list();
        }catch(HibernateException e){
            posts = null;            
        }finally{
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        
        return posts;
    }
   
    public static String addNewPost(Post p){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        String msg = "";
        
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(p);
            session.getTransaction().commit();
            session.flush();
            session.refresh(p);
            msg = "Post Added!";                    
        }catch(HibernateException e){
            msg = "Error Creating Post: " + e.getMessage();
            session.getTransaction().rollback();
        }finally{            
           session.close();
        }
        
        return msg;
    }
}
