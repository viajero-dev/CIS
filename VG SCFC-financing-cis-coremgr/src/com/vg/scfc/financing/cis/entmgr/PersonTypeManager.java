/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.scfc.financing.cis.ent.PersonType;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author raffy
 */
public class PersonTypeManager {

    private static PersonTypeManager instance;

    public static PersonTypeManager getInstance() {
        if (instance == null) {
            instance = new PersonTypeManager();
        }
        return instance;
    }

    public PersonType findById(String personTypeId) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        PersonType personType = new PersonType();
        Criteria criteria = session.createCriteria(PersonType.class);
        criteria.add(Restrictions.eq("typeID", personTypeId));
        personType = (PersonType) criteria.uniqueResult();

        session.getTransaction().commit();
        session.close();

        return personType;
    }
}
