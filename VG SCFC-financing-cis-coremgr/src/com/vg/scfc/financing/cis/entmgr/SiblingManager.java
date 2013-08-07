/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.Sibling;
import com.vg.scfc.financing.cis.interceptor.ClientInfoInterceptor;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jp
 */
public class SiblingManager {

    private static SiblingManager instance;

    public static SiblingManager getInstance() {
        if (instance == null) {
            instance = new SiblingManager();
        }
        return instance;

    }

    public synchronized Sibling insert(Sibling sibling) {
        Sibling tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(infoInterceptor);

        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(sibling.getLocation());

        session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(Sibling.class);
            criteria.add(Restrictions.eq("pk.txFormNo", sibling.getTxFormNo()));
            criteria.addOrder(Order.desc("pk.lineNo"));
            criteria.setMaxResults(1);
            Sibling exSibling = (Sibling) criteria.uniqueResult();

            int nLineNo = 0;
            if (exSibling == null) {
                nLineNo = 1;
            } else {
                nLineNo = exSibling.getLineNo();
                nLineNo++;
            }

            sibling.setLineNo(nLineNo);
            session.save(sibling);

            session.getTransaction().commit();
            tx = sibling;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(SiblingManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;
    }

    public Sibling update(Sibling sibling) {
        Sibling tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(infoInterceptor);

        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(sibling.getLocation());

        session.beginTransaction();
        try {
            session.update(sibling);
            session.getTransaction().commit();
            tx = sibling;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(SiblingManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;
    }

    public List<Sibling> findByFormNo(String formNo) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Sibling.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        List<Sibling> xSiblings = criteria.list();
        session.getTransaction().commit();
        session.close();
        return xSiblings;
    }

    public boolean isExist(String formNo, String siblingName) {
        boolean tx = false;
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Sibling.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.add(Restrictions.eq("siblingName", siblingName));

        if (criteria.uniqueResult() != null) {
            tx = true;
        }

        session.getTransaction().commit();
        session.close();
        return tx;
    }
}
