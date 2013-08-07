/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.Company;
import com.vg.scfc.financing.cis.ent.Customer;
import com.vg.scfc.financing.cis.ent.CustomerCashInfo;
import com.vg.scfc.financing.cis.ent.PersonalInfo;
import com.vg.scfc.financing.cis.ent.TransactionForm;
import com.vg.scfc.financing.cis.interceptor.ClientInfoInterceptor;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;

/**
 *
 * @author raffy
 */
public class CustomerManager {

    private static CustomerManager instance;

    public static CustomerManager getInstance() {
        if (instance == null) {
            instance = new CustomerManager();
        }
        return instance;
    }

    //installment
    public synchronized boolean insert(Customer customer, TransactionForm form,
            PersonalInfo personalInfo) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(customer.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            String transNo = getInstance().generateNewClientNo(
                    customer.getLocation().getFinStartCode(), session);
            customer.setClientNo(transNo);
            form.setClientNo(transNo);
            personalInfo.setClientNo(transNo);

            session.save(customer);
            session.save(form);
            session.save(personalInfo);

            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
            LoggerFactory.getLogger(CustomerManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    //institution
    public synchronized boolean insert(Customer customer, TransactionForm form,
            Company company) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(customer.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            String transNo = getInstance().generateNewClientNo(
                    customer.getLocation().getFinStartCode(), session);
            customer.setClientNo(transNo);
            form.setClientNo(transNo);
            
            session.save(customer);
            session.save(form);
            session.save(company);

            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(CustomerManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    //cash
    public synchronized boolean insert(Customer customer, CustomerCashInfo customerCashInfo) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(customer.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            String transNo = getInstance().generateNewClientNo(
                    customer.getLocation().getFinStartCode(), session);
            customer.setClientNo(transNo);
            customerCashInfo.setClientNo(transNo);

            session.save(customer);
            session.save(customerCashInfo);

            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(CustomerManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    public synchronized boolean update(Customer customer, PersonalInfo personalInfo) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(personalInfo.getLocation());

        boolean isSuccessful = false;
        try {
            session.update(customer);
            session.update(personalInfo);

            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(CustomerManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    public synchronized boolean update(Customer customer, Company company) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(company.getLocation());

        boolean isSuccessful = false;
        try {
            session.update(customer);
            session.update(company);

            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(CustomerManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    public synchronized boolean update(Customer customer, CustomerCashInfo customerCashInfo) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(customerCashInfo.getLocation());

        boolean isSuccessful = false;
        try {
            session.update(customer);
            session.update(customerCashInfo);

            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(CustomerManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    private String getLastClientNo(String prefix, Session session) {
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.setProjection(Projections.max("clientNo"));
        criteria.add(Restrictions.like("clientNo", prefix, MatchMode.START));
        String transNo = (String) criteria.uniqueResult();
        if (transNo == null || transNo.isEmpty()) {
            return "0000000";
        } else {
            return transNo.substring(1);
        }
    }

    private String generateNewClientNo(String prefix, Session session) {
        String newTransNo = StringUtils.generateNextSeriesNo(getLastClientNo(prefix, session));
        return (prefix + newTransNo);
    }

    public Customer findById(String clientNo) throws Exception {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Customer customer = new Customer();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("clientNo", clientNo));
        customer = (Customer) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();

        return customer;
    }
    
    public List<Customer> findByTransactionMode(int transactionModeId) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        List<Customer> customers = new ArrayList<Customer>();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("transactionMode.id", transactionModeId));
        criteria.addOrder(Order.asc("name"));
        customers = (List<Customer>) criteria.list();
        session.getTransaction().commit();
        session.close();

        return customers;
    }

    public List<Customer> filterBy(String searchString, int transactionModeId) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Customer> customers = new ArrayList<Customer>();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("transactionMode.id", transactionModeId));
        criteria.add(Restrictions.or(Restrictions.like("clientNo", searchString, MatchMode.ANYWHERE),
                Restrictions.like("name", searchString, MatchMode.ANYWHERE))).addOrder(Order.asc("name"));
        customers = (List<Customer>) criteria.list();
        session.getTransaction().commit();
        session.close();

        return customers;
    }

    public boolean isExist(String name) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Customer> customers = new ArrayList<Customer>();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.like("name", name, MatchMode.EXACT));
        criteria.addOrder(Order.asc("name"));
        customers = (List<Customer>) criteria.list();
        session.getTransaction().commit();
        session.close();

        if (customers.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
