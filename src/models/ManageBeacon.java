package models;

import mypaydbmap.StoreEntity;
import org.hibernate.SessionFactory;

/**
 * Created by Hessam! on 13.12.2016.
 */
public class ManageBeacon {
    SessionFactory sessionFactory ;
    public ManageBeacon(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public StoreEntity getStore(String uuid,int major,int minor)
    {
        return null;
    }

}
