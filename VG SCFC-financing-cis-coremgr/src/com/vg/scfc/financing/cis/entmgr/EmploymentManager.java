/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.Employment;
import com.vg.scfc.financing.cis.interceptor.ClientInfoInterceptor;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;

/**
 *
 * @author raffy
 */
public class EmploymentManager {

    private static EmploymentManager instance;

    public static EmploymentManager getInstance() {
        if (instance == null) {
            instance = new EmploymentManager();
        }
        return instance;
    }

    public synchronized boolean insert(Employment employment) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(employment.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            session.save(employment);
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(EmploymentManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    public synchronized boolean update(Employment employment) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(employment.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            session.update(employment);
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(EmploymentManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    public Employment findByFormNo(String formNo) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Employment employment = new Employment();
        Criteria criteria = session.createCriteria(Employment.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        employment = (Employment) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();

        return employment;
    }
}
