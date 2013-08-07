/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.scfc.financing.cis.ent.TransactionMode;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import org.hibernate.Session;

/**
 *
 * @author jp
 */
public class TransactionModeManager {

    private static TransactionModeManager instance;

    public static TransactionModeManager getInstance() {
        if (instance == null) {
            instance = new TransactionModeManager();
        }
        return instance;
    }

    public TransactionMode findByID(int id) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TransactionMode tx = (TransactionMode) session.get(TransactionMode.class, id);
        session.getTransaction().commit();
        session.close();
        return tx;
    }
}
