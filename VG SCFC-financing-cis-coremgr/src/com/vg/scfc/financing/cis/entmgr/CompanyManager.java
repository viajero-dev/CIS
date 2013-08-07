/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.scfc.financing.cis.ent.Company;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author raffy
 */
public class CompanyManager {
    
    private static CompanyManager instance;

    public static CompanyManager getInstance() {
        if(instance == null) instance = new CompanyManager();
        return instance;
    }

    public static void setInstance(CompanyManager instance) {
        CompanyManager.instance = instance;
    }
        
    public Company findByFormNo(String formNo) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Company company = new Company();
        Criteria criteria = session.createCriteria(Company.class)
                .add(Restrictions.eq("txFormNo", formNo));    
        company = (Company) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();
        
        return company;
    } 
    
}
