/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Alyssa
 */
public class OpponentDB {
    public static Opponent findOpponent(int oppID){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Opponent opp = null;
        
        try{
            String qS = "FROM Opponent o WHERE o.id = :oppID";
            session = sessionFactory.openSession();
            Query q = session.createQuery(qS);
            q.setParameter("oppID", oppID);
            opp = (Opponent) q.uniqueResult();
        }catch(NoResultException e){
            return null;
        }finally{
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        
        return opp;
    }
}
