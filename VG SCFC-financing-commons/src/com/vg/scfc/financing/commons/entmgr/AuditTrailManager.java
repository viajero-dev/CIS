/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.entmgr;

import com.vg.scfc.financing.commons.ent.AuditTrail;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jp
 */
public class AuditTrailManager {

    private static AuditTrailManager instance;

    public static AuditTrailManager getInstance() {
        if (instance == null) {
            instance = new AuditTrailManager();
        }
        return instance;
    }

    public String findLastTransNoBySystemName(Session session, String systemName) throws Exception {
        String lastTransNo = "";

        String location = UpdateSettingManager.getInstance().getCurrentLocation(session);
        Criteria criteria = session.createCriteria(AuditTrail.class);
        criteria.setProjection(Projections.max("txNo"));
        criteria.add(Restrictions.like("txNo", location + systemName + "%"));

        lastTransNo = (String) criteria.uniqueResult();
        if (lastTransNo == null) {
            lastTransNo = location.toUpperCase() + systemName.toUpperCase() + "00000000";
        }

        return lastTransNo;
    }
}
