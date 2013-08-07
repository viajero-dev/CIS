/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.Asset;
import com.vg.scfc.financing.cis.ent.Land;
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
public class LandManager {

    private static LandManager instance;

    public static LandManager getInstance() {
        if (instance == null) {
            instance = new LandManager();
        }
        return instance;
    }

    public synchronized Land insert(String asset, Land land) {
        Land tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession();

        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(land.getLocation());

        session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(Asset.class);
            criteria.add(Restrictions.eq("txFormNo", asset));
            criteria.setFetchMode("lands", FetchMode.JOIN);
            Asset xAsset = (Asset) criteria.uniqueResult();
            land.setAsset(xAsset);
            xAsset.getLands().add(land);
            session.save(land);
            session.getTransaction().commit();
            tx = land;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(LandManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;
    }

    public Land update(Land land) {
        Land tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(infoInterceptor);
        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(land.getLocation());
        session.beginTransaction();
        try {
            session.update(land);
            session.getTransaction().commit();
            tx = land;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(LandManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;
    }

    public List<Land> findByAsset(String form) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Asset.class);
        criteria.add(Restrictions.eq("txFormNo", form));
        criteria.setFetchMode("lands", FetchMode.JOIN);
        Asset xAsset = (Asset) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return xAsset.getLands();
    }
}
