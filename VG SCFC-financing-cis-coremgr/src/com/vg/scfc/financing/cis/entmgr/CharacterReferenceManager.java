/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.CharacterReference;
import com.vg.scfc.financing.cis.interceptor.ClientInfoInterceptor;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;

/**
 *
 * @author raffy
 */
public class CharacterReferenceManager {

    private static CharacterReferenceManager instance;

    public static CharacterReferenceManager getInstance() {
        if (instance == null) {
            instance = new CharacterReferenceManager();
        }
        return instance;
    }

    public synchronized boolean insert(CharacterReference characterReference) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(characterReference.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            characterReference.setLineNo(getInstance().getLastLineNo(characterReference.getTxFormNo(), session) + 1);
            session.save(characterReference);
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(CharacterReferenceManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    public synchronized boolean update(CharacterReference characterReference) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(characterReference.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            session.update(characterReference);
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(CharacterReferenceManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    private int getLastLineNo(String formNo, Session session) {
        int lastLineNo = 0;
        Criteria criteria = session.createCriteria(CharacterReference.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.addOrder(Order.desc("pk.lineNo"));
        List<CharacterReference> characterReferences = (List<CharacterReference>) criteria.list();

        if(characterReferences.isEmpty()) 
            return lastLineNo;
        else
            return characterReferences.get(0).getLineNo();
    }
    
    public CharacterReference findById(String formNo, int lineNo) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        CharacterReference characterReference = new CharacterReference();
        Criteria criteria = session.createCriteria(CharacterReference.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.add(Restrictions.eq("pk.lineNo", lineNo));
        characterReference = (CharacterReference) criteria.uniqueResult();
        
        session.getTransaction().commit();
        session.close();

        return characterReference;
    }

    public List<CharacterReference> findByFormNo(String formNo) throws Exception {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<CharacterReference> characterReferences = new ArrayList<CharacterReference>();
        Criteria criteria = session.createCriteria(CharacterReference.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.addOrder(Order.asc("pk.lineNo"));
        characterReferences = (List<CharacterReference>) criteria.list();
        session.getTransaction().commit();
        session.close();

        return characterReferences;
    }

    public boolean isExist(CharacterReference characterReference) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        List<CharacterReference> characterReferences = new ArrayList<CharacterReference>();
        Criteria criteria = session.createCriteria(CharacterReference.class);
        criteria.add(Restrictions.eq("pk.txFormNo", characterReference.getTxFormNo()));
        criteria.add(Restrictions.eq("charRefName", characterReference.getCharRefName().trim()));
        characterReferences = (List<CharacterReference>) criteria.list();
        
        session.getTransaction().commit();
        session.close();

        if (characterReferences.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}