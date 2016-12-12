package models;

import org.hibernate.SessionFactory;

/**
 * Created by Hessam! on 13.12.2016.
 */
public class ManageBeacon {
    SessionFactory sessionFactory ;
    public ManageBeacon(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
