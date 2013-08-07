/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.PurchaseOrder;
import com.vg.scfc.financing.cis.interceptor.ClientInfoInterceptor;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jp
 */
public class PurchaseOrderManager {

    private static PurchaseOrderManager instance;

    public static PurchaseOrderManager getInstance() {
        if (instance == null) {
            instance = new PurchaseOrderManager();
        }
        return instance;
    }

    public PurchaseOrder insert(PurchaseOrder purchaseOrder) {
        PurchaseOrder tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(infoInterceptor);
        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(purchaseOrder.getLocation());

        session.beginTransaction();
        try {
            session.save(purchaseOrder);
            session.getTransaction().commit();
            tx = purchaseOrder;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(PurchaseOrderManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;

    }

    public PurchaseOrder update(PurchaseOrder purchaseOrder) {
        PurchaseOrder tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(infoInterceptor);
        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(purchaseOrder.getLocation());

        session.beginTransaction();
        try {
            session.update(purchaseOrder);
            session.getTransaction().commit();
            tx = purchaseOrder;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(PurchaseOrderManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;
    }

    public PurchaseOrder findByTransNo(String txFormNo) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        PurchaseOrder pu = (PurchaseOrder) session.get(PurchaseOrder.class, txFormNo);
        session.getTransaction().commit();
        session.close();
        return pu;
    }
}
