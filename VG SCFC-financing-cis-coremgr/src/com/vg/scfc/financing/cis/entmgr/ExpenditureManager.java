/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.Expenditure;
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
public class ExpenditureManager {

    private static ExpenditureManager instance;

    public static ExpenditureManager getInstance() {
        if (instance == null) {
            instance = new ExpenditureManager();
        }
        return instance;
    }
    
    public synchronized boolean insert(List<Expenditure> expenditures) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(expenditures.get(0).getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            for (Expenditure expenditure : expenditures) {
                session.save(expenditure);
            }
            
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(ExpenditureManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    public synchronized boolean update(List<Expenditure> expenditures) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(expenditures.get(0).getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            List<Expenditure> deleteExpenditures = getInstance().findByFormNo(expenditures.get(0).getTxFormNo(), session);
            for (Expenditure expenditure : deleteExpenditures) {
                expenditure.setStation(expenditures.get(0).getStation());
                expenditure.setLocation(expenditures.get(0).getLocation());
                expenditure.setUser(expenditures.get(0).getUser());
                
                session.delete(expenditure);
            }
            
            for (Expenditure expenditure : expenditures) {
                if(expenditure.getAmount() > 0.00) {
                    session.save(expenditure);
                }
            }

            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(ExpenditureManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    public Expenditure findById(String formNo, int expenditureTypeId) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Expenditure expenditure = new Expenditure();
        Criteria criteria = session.createCriteria(Expenditure.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.add(Restrictions.eq("pk.expenditureType.id", expenditureTypeId));
        expenditure = (Expenditure) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();

        return expenditure;
    }

    public List<Expenditure> findByFormNo(String formNo) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Expenditure> expenditures = new ArrayList<Expenditure>();
        Criteria criteria = session.createCriteria(Expenditure.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.addOrder(Order.asc("pk.expenditureType.id"));
        expenditures = (List<Expenditure>) criteria.list();
        session.getTransaction().commit();
        session.close();

        return expenditures;
    }
    
    private List<Expenditure> findByFormNo(String formNo, Session session) {
        List<Expenditure> expenditures = new ArrayList<Expenditure>();
        Criteria criteria = session.createCriteria(Expenditure.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.addOrder(Order.asc("pk.expenditureType.id"));
        expenditures = (List<Expenditure>) criteria.list();

        return expenditures;
    }
}
