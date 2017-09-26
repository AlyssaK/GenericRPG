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
public class MoveDB {
    public static List<Move> loadMoves(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        List<Move> moves = null;
        
        try{
            String qS = "FROM Move m";
            session = sessionFactory.openSession();
            Query q = session.createQuery(qS);            
            moves = q.list();
        }catch(HibernateException e){
            moves = null;            
        }finally{
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        
        return moves;
    }

     public static String addNewMove(Move m){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        String msg = "";
        
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(m);
            session.getTransaction().commit();
            session.flush();
            session.refresh(m);
            msg = "Move Added!";                    
        }catch(HibernateException e){
            msg = "Error Creating Move: " + e.getMessage();
            if(session!=null && session.isOpen()){
                session.getTransaction().rollback();
            }
        }finally{            
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        
        return msg;
    }
}
