/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.scfc.financing.cis.ent.TransactionForm;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jp
 */
public class TransactionFormManager {

    private static TransactionFormManager instance;

    public static TransactionFormManager getInstance() {
        if (instance == null) {
            instance = new TransactionFormManager();
        }
        return instance;
    }

    public void insetTx(TransactionForm tx, Session session) throws Exception {
        session.save(tx);
    }

    public List<TransactionForm> findByClientNo(String clientNo) throws Exception {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TransactionForm.class);
        criteria.add(Restrictions.eq("clientNo", clientNo));
        List<TransactionForm> xTransactionForms = criteria.list();
        session.getTransaction().commit();
        session.close();
        return xTransactionForms;
    }
}
