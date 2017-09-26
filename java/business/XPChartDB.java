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
public class XPChartDB {
    public static List<XPChart> loadXPChart(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        List<XPChart> xpchart = null;
        
        try{
            String qS = "FROM XPChart x";
            session = sessionFactory.openSession();
            Query q = session.createQuery(qS);
            xpchart = q.list();
        }catch(HibernateException e){
            xpchart = null;            
        }finally{
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        
        return xpchart;
    }
}
