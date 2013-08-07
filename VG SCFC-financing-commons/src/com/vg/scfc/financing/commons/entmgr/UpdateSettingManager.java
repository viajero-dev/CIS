/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.entmgr;

import com.vg.scfc.financing.commons.ent.UpdateSetting;
import com.vg.scfc.financing.commons.util.CommonsUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author jp
 */
public class UpdateSettingManager {

    private static UpdateSettingManager instance;

    public static UpdateSettingManager getInstance() {
        if (instance == null) {
            instance = new UpdateSettingManager();
        }
        return instance;
    }

    public String getCurrentLocation(Session session) {
        String xTx = "";

        Criteria criteria = session.createCriteria(UpdateSetting.class);
        UpdateSetting us = (UpdateSetting) criteria.uniqueResult();

        if (us != null) {
            xTx = us.getCurrLocation();
        }


        return xTx;
    }

    public String getCurrentLocation() {
        String xTx = "";
        Session session = CommonsUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UpdateSetting.class);
        UpdateSetting us = (UpdateSetting) criteria.uniqueResult();

        if (us != null) {
            xTx = us.getCurrLocation();
        }

        session.getTransaction().commit();
        session.close();

        return xTx;
    }
}
