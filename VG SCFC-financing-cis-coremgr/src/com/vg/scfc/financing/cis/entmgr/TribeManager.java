/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.scfc.financing.cis.ent.Tribe;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author jp
 */
public class TribeManager {

    private static TribeManager instance;

    public static TribeManager getInstance() {
        if (instance == null) {
            instance = new TribeManager();
        }
        return instance;
    }

    public List<Tribe> getList() {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Tribe.class);
        List<Tribe> xList = criteria.list();
        session.getTransaction().commit();
        session.close();
        return xList;
    }
}
