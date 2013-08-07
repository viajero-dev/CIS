/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.scfc.financing.cis.ent.Customer;
import com.vg.scfc.financing.cis.ent.CustomerCashInfo;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author raffy
 */
public class CustomerCashInfoManager {

    private static CustomerCashInfoManager instance;

    public static CustomerCashInfoManager getInstance() {
        if (instance == null) {
            instance = new CustomerCashInfoManager();
        }
        return instance;
    }

    public CustomerCashInfo findById(String clientNo) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CustomerCashInfo customerCashInfo = new CustomerCashInfo();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("clientNo", clientNo));
        customerCashInfo = (CustomerCashInfo) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();

        return customerCashInfo;
    }
}
