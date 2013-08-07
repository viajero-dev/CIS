/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.Asset;
import com.vg.scfc.financing.cis.ent.Machinery;
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
public class MachineryManager {

    private static MachineryManager instance;

    public static MachineryManager getInstance() {
        if (instance == null) {
            instance = new MachineryManager();
        }
        return instance;
    }

    public synchronized Machinery insert(String asset, Machinery machinery) {
        Machinery tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession();

        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(machinery.getLocation());

        session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(Asset.class);
            criteria.add(Restrictions.eq("txFormNo", asset));
            criteria.setFetchMode("machineries", FetchMode.JOIN);
            Asset xAsset = (Asset) criteria.uniqueResult();



            int nLineNo = 0;
            if (xAsset.getMachineries().isEmpty()) {
                nLineNo = 1;
            } else {
                nLineNo = xAsset.getMachineries().get(xAsset.getMachineries().size() - 1).getLineNo();
                nLineNo++;
            }

            machinery.setLineNo(nLineNo);

            machinery.setAsset(xAsset);
            xAsset.getMachineries().add(machinery);

            session.save(machinery);
            session.getTransaction().commit();

            tx = machinery;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(MachineryManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;
    }

    public Machinery update(Machinery machinery) {
        Machinery tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(infoInterceptor);
        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(machinery.getLocation());
        session.beginTransaction();
        try {
            session.update(machinery);
            session.getTransaction().commit();
            tx = machinery;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(MachineryManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;
    }

    public List<Machinery> findByAsset(String form) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Asset.class);
        criteria.add(Restrictions.eq("txFormNo", form));
        criteria.setFetchMode("machineries", FetchMode.JOIN);
        Asset xAsset = (Asset) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return xAsset.getMachineries();
    }

    public Machinery get() {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Machinery.class);
        criteria.add(Restrictions.eq("machineryPk.asset.txFormNo", "000001"));
        criteria.add(Restrictions.eq("machineryPk.lineNo", 1));
        Machinery xMachinery = (Machinery) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return xMachinery;

    }
}
