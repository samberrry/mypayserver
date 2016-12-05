package models;

import mypaydbmap.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by Hessam! on 05.12.2016.
 */
public class ManageUser {
    SessionFactory sessionFactory ;
    public ManageUser(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Integer addUser(String username,String password,String type,String phone,String email,Integer age){
        Session session = sessionFactory.openSession();
        Transaction tx;
        Integer id = null;
        try {
            tx = session.beginTransaction();
            UserEntity userEntity = new UserEntity(username,password,type,age,phone,email,(byte)1);
            id = (Integer)session.save(userEntity);
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
