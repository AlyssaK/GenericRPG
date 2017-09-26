/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Alyssa
 */
public class ChampionDB {
    
    public static Champion getChampionByID(int cid){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Champion c = null;
        
        try{
            String qS = "FROM Champion c WHERE c.id = :cid";
            session = sessionFactory.openSession();
            Query q = session.createQuery(qS);
            q.setParameter("cid", cid);
            c = (Champion) q.uniqueResult();
        }catch(HibernateException e){
            c = null;            
        }finally{
            if(session!=null && session.isOpen()){
                session.close();
            }
        }        
        return c;
    }
    
    
    
    public static List<Champion> loadChampions(int aid){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        List<Champion> champs = null;
        
        try{
            String qS = "FROM Champion c WHERE c.accountID = :aid";
            session = sessionFactory.openSession();
            Query q = session.createQuery(qS);
            q.setParameter("aid", aid);
            champs = q.list();
        }catch(HibernateException e){
            champs = null;            
        }finally{
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        
        return champs;
    }
  
     public static boolean checkChampionName(String name){
        boolean used = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Champion c;
        
        try{
            String qS = "FROM Champion c WHERE c.name = :name";
            session = sessionFactory.openSession();
            Query q = session.createQuery(qS);
            q.setParameter("name", name);
            c = (Champion) q.uniqueResult();
            used = true;
        }catch(NoResultException e){
            used = false;
        }finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }     
        
        return used;
    }
    
    public static String addNewChampion(Champion c){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        String msg = "";
        
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(c);            
            session.getTransaction().commit();
            session.flush();
            session.refresh(c);
            msg = "Champion Created!";                    
        }catch(HibernateException e){
            msg = "Error Creating Champion: " + e.getMessage();
            if(session!=null && session.isOpen()){
                session.getTransaction().rollback();
            }
        }finally{            
            session.close();
        }
        
        return msg;
    }
}
