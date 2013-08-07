/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.Family;
import com.vg.scfc.financing.cis.interceptor.ClientInfoInterceptor;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;

/**
 *
 * @author raffy
 */
public class FamilyManager {

    private static FamilyManager instance;

    public static FamilyManager getInstance() {
        if (instance == null) {
            instance = new FamilyManager();
        }
        return instance;
    }

    public synchronized boolean insert(Family family) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(family.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            session.save(family);
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(FamilyManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    public synchronized boolean update(Family family) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(family.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            session.update(family);
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(FamilyManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    public Family findById(String formNo, String personTypeId, String famRelation) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Family family = new Family();
        Criteria criteria = session.createCriteria(Family.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.add(Restrictions.eq("pk.personType.typeID", personTypeId));
        criteria.add(Restrictions.eq("pk.famRelation", famRelation));
        family = (Family) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();

        return family;
    }

    public List<Family> findById(String formNo, String personTypeId) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Family> families = new ArrayList<Family>();
        Criteria criteria = session.createCriteria(Family.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.add(Restrictions.eq("pk.personType.typeID", personTypeId));
        families = (List<Family>) criteria.list();
        session.getTransaction().commit();
        session.close();

        return families;
    }
}
