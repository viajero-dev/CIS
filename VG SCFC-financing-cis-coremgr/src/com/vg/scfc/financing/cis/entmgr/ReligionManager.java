/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.scfc.financing.cis.ent.Religion;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author jp
 */
public class ReligionManager {

    private static ReligionManager instance;

    public static ReligionManager getInstance() {
        if (instance == null) {
            instance = new ReligionManager();
        }
        return instance;
    }

    public List<Religion> findAll() {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Religion.class);
        List<Religion> xReligions = criteria.list();
        session.getTransaction().commit();
        session.close();
        return xReligions;
    }
}
