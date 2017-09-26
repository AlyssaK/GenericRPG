package business;

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
public class BattleDB {
    public static String addNewBattleTurn(Battle b){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        String msg = "";
        
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(b);
            session.getTransaction().commit();
            session.flush();
            session.refresh(b);
            msg = "Battle Turn Updated!";                    
        }catch(HibernateException e){
            msg = "Error Adding Turn: " + e.getMessage();
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
    
    public static int getBattleID(){
        int battleID = 0;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        
        try{
            String qS = "SELECT MAX(b.battleID) FROM Battle b";
            session = sessionFactory.openSession();
            Query q = session.createQuery(qS);             
            battleID = (int) q.uniqueResult() + 1;
        }catch(NoResultException e){

        }finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }     
        
        return battleID;
    }
}
