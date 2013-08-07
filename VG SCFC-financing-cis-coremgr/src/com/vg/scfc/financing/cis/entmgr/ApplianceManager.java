/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.Asset;
import com.vg.scfc.financing.cis.ent.Appliance;
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
public class ApplianceManager {

    private static ApplianceManager instance;

    public static ApplianceManager getInstance() {
        if (instance == null) {
            instance = new ApplianceManager();
        }
        return instance;
    }

    public synchronized Appliance insert(String asset, Appliance appliance) {
        Appliance tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession();

        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(appliance.getLocation());

        session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(Asset.class);
            criteria.add(Restrictions.eq("txFormNo", asset));
            criteria.setFetchMode("appliances", FetchMode.JOIN);
            Asset xAsset = (Asset) criteria.uniqueResult();

            int nLineNo = 0;
            if (xAsset.getAppliances().isEmpty()) {
                nLineNo = 1;
            } else {
                nLineNo = xAsset.getAppliances().get(xAsset.getAppliances().size() - 1).getLineNo();
                nLineNo++;
            }

            appliance.setLineNo(nLineNo);

            appliance.setAsset(xAsset);
            xAsset.getAppliances().add(appliance);

            session.save(appliance);
            session.getTransaction().commit();

            tx = appliance;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(ApplianceManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;
    }

    public Appliance update(Appliance appliance) {
        Appliance tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(infoInterceptor);
        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(appliance.getLocation());
        session.beginTransaction();
        try {
            session.update(appliance);
            session.getTransaction().commit();
            tx = appliance;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(ApplianceManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;
    }

    public List<Appliance> findByAsset(String form) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Asset.class);
        criteria.add(Restrictions.eq("txFormNo", form));
        criteria.setFetchMode("appliances", FetchMode.JOIN);
        Asset xAsset = (Asset) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return xAsset.getAppliances();
    }

    public Appliance get() {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Appliance.class);
        criteria.add(Restrictions.eq("appliancePk.asset.txFormNo", "000001"));
        criteria.add(Restrictions.eq("appliancePk.lineNo", 1));
        Appliance xAppliance = (Appliance) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return xAppliance;

    }
}
