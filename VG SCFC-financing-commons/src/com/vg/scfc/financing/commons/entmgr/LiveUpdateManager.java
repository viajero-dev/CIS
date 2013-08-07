/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.entmgr;

import com.vg.scfc.financing.commons.ent.LiveUpdate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jp
 */
public class LiveUpdateManager {

    private static LiveUpdateManager instance;

    public static LiveUpdateManager getInstance() {
        if (instance == null) {
            instance = new LiveUpdateManager();
        }
        return instance;
    }

    public synchronized String findLastTransNoBySystemName(Session session, String system) throws Exception {
        String lastTransNo = "";

        String location = UpdateSettingManager.getInstance().getCurrentLocation(session);
        Criteria criteria = session.createCriteria(LiveUpdate.class);
        criteria.setProjection(Projections.max("transNo"));
        criteria.add(Restrictions.like("transNo", location + system + "%"));
        lastTransNo = (String) criteria.uniqueResult();

        if (lastTransNo == null) {
            lastTransNo = location + system + "00000000";

        }



        return lastTransNo;
    }
}
