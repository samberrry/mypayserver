package models;

import mypaydbmap.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

/**
 * Created by Hessam! on 05.12.2016.
 */
public class ManageUser {
    SessionFactory sessionFactory ;
    public ManageUser(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean authenticateUser(String username,String password)
    {
        boolean bool = false;
        Session session = sessionFactory.openSession();
        Transaction tx;
        try{
            tx = session.beginTransaction();
            String hql = "select users.password from UserEntity users where users.username= :username";
            org.hibernate.query.Query query = session.createQuery(hql);
            query.setParameter("username",username);
            List<String> pass = query.list();
            for (String pas :
                    pass) {
                if (pas.compareTo(password) == 0) {
                    return true;
                }
            }
            tx.commit();
        }catch (Exception e)
        {
            System.err.println(e);
        }finally {
            session.close();
        }
        return bool;
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
