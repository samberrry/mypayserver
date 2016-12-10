package models;

import mypaydbmap.LogEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by Hessam! on 09.12.2016.
 */
public class ManageLog {
    SessionFactory sessionFactory ;
    public ManageLog(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Integer addLog(int logid,String name,String description){
        Session session = sessionFactory.openSession();
        Transaction tx;
        Integer id = null;
        try {
            tx = session.beginTransaction();
            LogEntity logEntity = new LogEntity(logid,name,description);
            id = (Integer)session.save(logEntity);
            tx.commit();
        }catch (Exception e){
            System.err.println(e);
        }
        finally {
            session.close();
        }
        return id;
    }

}
