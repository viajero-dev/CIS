/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.RepresentativeEmployment;
import com.vg.scfc.financing.cis.interceptor.ClientInfoInterceptor;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jp
 */
public class RepresentativeEmploymentManager {

    private static RepresentativeEmploymentManager instance;

    public static RepresentativeEmploymentManager getInstance() {
        if (instance == null) {
            instance = new RepresentativeEmploymentManager();
        }
        return instance;
    }

    public synchronized RepresentativeEmployment insert(RepresentativeEmployment employment) {
        RepresentativeEmployment tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(employment.getLocation());
        session.beginTransaction();

        try {
            session.save(employment);
            session.getTransaction().commit();
            tx = employment;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(RepresentativeEmploymentManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;
    }

    public synchronized RepresentativeEmployment update(RepresentativeEmployment employment) {
        RepresentativeEmployment tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(employment.getLocation());
        session.beginTransaction();

        try {
            session.update(employment);
            session.getTransaction().commit();
            tx = employment;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(RepresentativeEmploymentManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;
    }

    public RepresentativeEmployment findByFormPersonType(String form, String type) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RepresentativeEmployment.class);
        criteria.add(Restrictions.eq("pk.txFormNo", form));
        criteria.add(Restrictions.eq("pk.personType.typeID", type));
        RepresentativeEmployment employment = (RepresentativeEmployment) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return employment;
    }
}
