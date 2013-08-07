/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.Dependent;
import com.vg.scfc.financing.cis.interceptor.ClientInfoInterceptor;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;

/**
 *
 * @author raffy
 */
public class DependentManager {

    private static DependentManager instance;

    public static DependentManager getInstance() {
        if (instance == null) {
            instance = new DependentManager();
        }
        return instance;
    }

    public synchronized boolean insert(Dependent dependent) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(dependent.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            dependent.setLineNo(getInstance().getLastLineNo(dependent.getTxFormNo(), session) + 1);
            session.save(dependent);
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(DependentManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    public synchronized boolean update(Dependent dependent) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(dependent.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            session.update(dependent);
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(DependentManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    private int getLastLineNo(String formNo, Session session) {
        int lastLineNo = 0;
        Criteria criteria = session.createCriteria(Dependent.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.addOrder(Order.desc("pk.lineNo"));
        List<Dependent> dependents = (List<Dependent>) criteria.list();

        if(dependents.isEmpty()) 
            return lastLineNo;
        else
            return dependents.get(0).getLineNo();
    }
    
    public Dependent findById(String formNo, int lineNo) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Dependent dependent = new Dependent();
        Criteria criteria = session.createCriteria(Dependent.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.add(Restrictions.eq("pk.lineNo", lineNo));
        dependent = (Dependent) criteria.uniqueResult();
        
        session.getTransaction().commit();
        session.close();

        return dependent;
    }

    public List<Dependent> findByFormNo(String formNo) throws Exception {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Dependent> dependents = new ArrayList<Dependent>();
        Criteria criteria = session.createCriteria(Dependent.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.addOrder(Order.asc("pk.lineNo"));
        dependents = (List<Dependent>) criteria.list();
        session.getTransaction().commit();
        session.close();

        return dependents;
    }

    public boolean isExist(Dependent dependent) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        List<Dependent> dependents = new ArrayList<Dependent>();
        Criteria criteria = session.createCriteria(Dependent.class);
        criteria.add(Restrictions.eq("pk.txFormNo", dependent.getTxFormNo()));
        criteria.add(Restrictions.eq("depName", dependent.getDepName().trim()));
        dependents = (List<Dependent>) criteria.list();

        session.getTransaction().commit();
        session.close();

        if (dependents.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
