/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.SourceOfIncome;
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
public class SourceOfIncomeManager {

    private static SourceOfIncomeManager instance;

    public static SourceOfIncomeManager getInstance() {
        if (instance == null) {
            instance = new SourceOfIncomeManager();
        }
        return instance;
    }

    public synchronized SourceOfIncome insert(SourceOfIncome income) {
        SourceOfIncome tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(infoInterceptor);
        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(income.getLocation());
        session.beginTransaction();
        try {
            session.save(income);
            session.getTransaction().commit();
            tx = income;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(SourceOfIncomeManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;
    }

    public synchronized SourceOfIncome update(SourceOfIncome income) {
        SourceOfIncome tx = null;
        ClientInfoInterceptor infoInterceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(infoInterceptor);
        infoInterceptor.setSession(session);
        infoInterceptor.setLocation(income.getLocation());
        session.beginTransaction();
        try {
            session.update(income);
            session.getTransaction().commit();
            tx = income;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(SourceOfIncomeManager.class).error(StringUtils.formatException(e));
        } finally {
            session.close();
        }
        return tx;
    }

    public SourceOfIncome findByClientFormNoPersonType(String clientNo, String form, String typeID) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(SourceOfIncome.class);
        criteria.add(Restrictions.eq("pk.txForm.txFormNo", form));
        criteria.add(Restrictions.eq("pk.clientNo", clientNo));
        criteria.add(Restrictions.eq("pk.personType.typeID", typeID));
        SourceOfIncome tx = (SourceOfIncome) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return tx;
    }
}
