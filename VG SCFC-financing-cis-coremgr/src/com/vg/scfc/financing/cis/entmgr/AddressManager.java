/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.Address;
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
public class AddressManager {

    private static AddressManager instance;

    public static AddressManager getInstance() {
        if (instance == null) {
            instance = new AddressManager();
        }
        return instance;
    }

    public synchronized boolean insert(Address address) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(address.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            address.setAddressId(getInstance().generateNewAddressId(address.getLocation().getId(), session));
            if (address.getDescription().equals("PRESENT ADDRESS")) {
                address.setLineNo(1);
            } else {
                address.setLineNo(2);
            }
            
            session.save(address);
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(AddressManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    public synchronized boolean update(Address address) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(address.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            session.update(address);
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(AddressManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    public synchronized boolean changeAddress(Address address) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(address.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            List<Address> addresses = getInstance().filterBy(address.getClientNo(),
                    address.getTxFormNo(), address.getPersonType().getTypeID(), session);
            int counter = 2;
            for (Address addr : addresses) {
                addr.setDescription("PREVIOUS ADDRESS");
                addr.setLineNo(counter);
                addr.setStation(address.getStation());
                addr.setLocation(address.getLocation());
                addr.setUser(address.getUser());
                
                counter++;
            }

            address.setAddressId(getInstance().generateNewAddressId(address.getLocation().getId(), session));
            address.setLineNo(1);
            session.save(address);

            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(AddressManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }
    
    public Address findById(String addressId) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Address address = (Address) session.get(Address.class, addressId);
        session.getTransaction().commit();
        session.close();
        
        return address;
    }

    private List<Address> filterBy(String clientNo, String formNo, String personTypeId, Session session) {
        List<Address> addresses = new ArrayList<Address>();
        Criteria criteria = session.createCriteria(Address.class);
        criteria.add(Restrictions.eq("clientNo", clientNo));
        criteria.add(Restrictions.eq("txFormNo", formNo));
        criteria.add(Restrictions.eq("personType.typeID", personTypeId));
        criteria.addOrder(Order.asc("lineNo"));
        addresses = (List<Address>) criteria.list();

        return addresses;
    }

    public List<Address> filterBy(String clientNo, String formNo, String personTypeId) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Address> addresses = new ArrayList<Address>();
        Criteria criteria = session.createCriteria(Address.class);
        criteria.add(Restrictions.eq("clientNo", clientNo));
        criteria.add(Restrictions.eq("txFormNo", formNo));
        criteria.add(Restrictions.eq("personType.typeID", personTypeId));
        criteria.addOrder(Order.asc("lineNo"));
        addresses = (List<Address>) criteria.list();
        session.getTransaction().commit();
        session.close();

        return addresses;
    }
    
    private String getLastAddressId(String locationId, Session session) {
        Criteria criteria = session.createCriteria(Address.class);
        criteria.setProjection(Projections.max("addressId"));
        criteria.add(Restrictions.like("addressId", locationId, MatchMode.START));
        String transNo = (String) criteria.uniqueResult();
        if (transNo == null || transNo.isEmpty()) {
            return "000000";
        } else {
            return transNo.substring(4);
        }
    }

    private String generateNewAddressId(String locationId, Session session) {
        String newTransNo = StringUtils.generateNextSeriesNo(getLastAddressId(locationId, session));
        return (locationId + newTransNo);
    }
}
