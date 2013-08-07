/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.scfc.financing.cis.ent.ExpenditureType;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author raffy
 */
public class ExpenditureTypeManager {
    
    private static ExpenditureTypeManager instance;

    public static ExpenditureTypeManager getInstance() {
        if(instance == null) instance = new ExpenditureTypeManager();
        return instance;
    }
    
    public ExpenditureType findById(int expenditureTypeId) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        ExpenditureType expenditureType = (ExpenditureType) session.get(ExpenditureType.class, expenditureTypeId);
        
        session.getTransaction().commit();
        session.close();
        
        return expenditureType;
    }
    
    public List<ExpenditureType> getAll() {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        List<ExpenditureType> expenditureTypes = new ArrayList<ExpenditureType>();
        Criteria criteria = session.createCriteria(ExpenditureType.class);
        criteria.addOrder(Order.asc("id"));
        expenditureTypes = (List<ExpenditureType>) criteria.list();
        
        session.getTransaction().commit();
        session.close();
        
        return expenditureTypes;
    }
}
