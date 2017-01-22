package models;

import mypaydbmap.BeaconEntity;
import mypaydbmap.StoreEntity;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import java.util.List;

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
        Integer storeID = null;
        StoreEntity desiredStore = null;
        Session session = sessionFactory.openSession();
        Transaction tx;
        try {
            tx = session.beginTransaction();
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<BeaconEntity> criteria = builder.createQuery(BeaconEntity.class);
            /*Criteria cr = session.createCriteria(BeaconEntity.class)
                    .add(Restrictions.disjunction()
                            .add(Restrictions.eq("uuid", uuid))
                            .add(Restrictions.eq("major", major))
                            .add(Restrictions.eq("minor", minor))
                    );*/

//            List<BeaconEntity> results = cr.list();

            String hql = "select beacons.idstore from BeaconEntity beacons where (beacons.major= :major) AND (beacons.minor= :minor) AND (beacons.uuid= :uuid)";
            org.hibernate.query.Query query = session.createQuery(hql);
            query.setParameter("uuid",uuid);
            query.setParameter("major",major);
            query.setParameter("minor",minor);

            List<Integer> results = query.list();

            for (Integer storeid :
                    results) {
                 storeID = storeid;
            }
            tx.commit();
            if(storeID != null) {
                tx = session.beginTransaction();
                Criteria cr2 = session.createCriteria(StoreEntity.class)
                        .add(Restrictions.disjunction()
                                .add(Restrictions.eq("idstore", storeID))
                        );
                List<StoreEntity> results2 = cr2.list();
                for (StoreEntity store :
                        results2) {
                    desiredStore = store;
                }
                tx.commit();
            }
        }catch (Exception e){
            System.err.println(e);
        }
        finally {
            session.close();
        }
        return desiredStore;
    }
}
