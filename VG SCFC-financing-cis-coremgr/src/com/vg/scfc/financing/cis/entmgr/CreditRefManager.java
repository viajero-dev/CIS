/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.CreditRef;
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
public class CreditRefManager {

    private static CreditRefManager instance;

    public static CreditRefManager getInstance() {
        if (instance == null) {
            instance = new CreditRefManager();
        }
        return instance;
    }

    public synchronized boolean insert(CreditRef creditRef) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(creditRef.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            creditRef.setLineNo(getInstance().getLastLineNo(creditRef.getTxFormNo(), session) + 1);
            session.save(creditRef);
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(CreditRefManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    public synchronized boolean update(CreditRef creditRef) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(creditRef.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            session.update(creditRef);
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(CreditRefManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    private int getLastLineNo(String formNo, Session session) {
        int lastLineNo = 0;
        Criteria criteria = session.createCriteria(CreditRef.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.addOrder(Order.desc("pk.lineNo"));
        List<CreditRef> creditRefs = (List<CreditRef>) criteria.list();

        if(creditRefs.isEmpty()) 
            return lastLineNo;
        else
            return creditRefs.get(0).getLineNo();
    }
    
    public CreditRef findById(String formNo, int lineNo) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        CreditRef creditRef = new CreditRef();
        Criteria criteria = session.createCriteria(CreditRef.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.add(Restrictions.eq("pk.lineNo", lineNo));
        creditRef = (CreditRef) criteria.uniqueResult();
        
        session.getTransaction().commit();
        session.close();

        return creditRef;
    }

    public List<CreditRef> findByFormNo(String formNo) throws Exception {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<CreditRef> creditRefs = new ArrayList<CreditRef>();
        Criteria criteria = session.createCriteria(CreditRef.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.addOrder(Order.asc("pk.lineNo"));
        creditRefs = (List<CreditRef>) criteria.list();
        session.getTransaction().commit();
        session.close();

        return creditRefs;
    }

    public boolean isExist(CreditRef creditRef) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        List<CreditRef> creditRefs = new ArrayList<CreditRef>();
        Criteria criteria = session.createCriteria(CreditRef.class);
        criteria.add(Restrictions.eq("pk.txFormNo", creditRef.getTxFormNo()));
        criteria.add(Restrictions.eq("creRefName", creditRef.getCreRefName().trim()));
        creditRefs = (List<CreditRef>) criteria.list();

        session.getTransaction().commit();
        session.close();

        if (creditRefs.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
