/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.Asset;
import com.vg.scfc.financing.cis.ent.Vehicle;
import com.vg.scfc.financing.cis.interceptor.ClientInfoInterceptor;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jp
 */
public class VehicleManager {

    private static VehicleManager instance;

    public static VehicleManager getInstance() {
        if (instance == null) {
            instance = new VehicleManager();
        }
        return instance;
    }

    public synchronized Vehicle insert(String asset, Vehicle vehicle) {
        Vehicle tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession();

        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(vehicle.getLocation());

        session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(Asset.class);
            criteria.add(Restrictions.eq("txFormNo", asset));
            criteria.setFetchMode("vehicles", FetchMode.JOIN);
            Asset xAsset = (Asset) criteria.uniqueResult();

            int nLineNo = 0;
            if (xAsset.getVehicles().isEmpty()) {
                nLineNo = 1;
            } else {
                nLineNo = xAsset.getVehicles().get(xAsset.getVehicles().size() - 1).getLineNo();
                nLineNo++;
            }

            vehicle.setLineNo(nLineNo);

            vehicle.setAsset(xAsset);
            xAsset.getVehicles().add(vehicle);

            session.save(vehicle);
            session.getTransaction().commit();

            tx = vehicle;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(VehicleManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;
    }

    public Vehicle update(Vehicle vehicle) {
        Vehicle tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(infoInterceptor);
        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(vehicle.getLocation());
        session.beginTransaction();
        try {
            session.update(vehicle);
            session.getTransaction().commit();
            tx = vehicle;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(VehicleManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;
    }

    public List<Vehicle> findByAsset(String form) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Asset.class);
        criteria.add(Restrictions.eq("txFormNo", form));
        criteria.setFetchMode("vehicles", FetchMode.JOIN);
        Asset xAsset = (Asset) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return xAsset.getVehicles();
    }

    public Vehicle get() {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Vehicle.class);
        criteria.add(Restrictions.eq("vehiclePk.asset.txFormNo", "000001"));
        criteria.add(Restrictions.eq("vehiclePk.lineNo", 1));
        Vehicle xVehicle = (Vehicle) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return xVehicle;

    }
}
