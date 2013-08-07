/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ent.MemoToFile;
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
public class MemoToFileManager {

    private static MemoToFileManager instance;

    public static MemoToFileManager getInstance() {
        if (instance == null) {
            instance = new MemoToFileManager();
        }
        return instance;
    }

    public synchronized boolean insert(MemoToFile memoToFile) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(memoToFile.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            memoToFile.setLineNo(getInstance().getLastLineNo(memoToFile.getTxFormNo(), session) + 1);
            session.save(memoToFile);
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(MemoToFileManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }

    public synchronized boolean update(MemoToFile memoToFile) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(memoToFile.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            session.update(memoToFile);
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(MemoToFileManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }
    
    public synchronized boolean delete(MemoToFile memoToFile) {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(memoToFile.getLocation());
        session.beginTransaction();

        boolean isSuccessful = false;
        try {
            session.delete(memoToFile);            
            session.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LoggerFactory.getLogger(MemoToFileManager.class).error(StringUtils.formatException(e));
            isSuccessful = false;
        } finally {
            session.close();
            return isSuccessful;
        }
    }
    
    private int getLastLineNo(String formNo, Session session) {
        int lastLineNo = 0;
        Criteria criteria = session.createCriteria(MemoToFile.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.addOrder(Order.desc("pk.lineNo"));
        List<MemoToFile> memoToFiles = (List<MemoToFile>) criteria.list();

        if(memoToFiles.isEmpty()) 
            return lastLineNo;
        else
            return memoToFiles.get(0).getLineNo();
    }

    public MemoToFile findById(String formNo, int lineNo) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        MemoToFile memoToFile = new MemoToFile();
        Criteria criteria = session.createCriteria(MemoToFile.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.add(Restrictions.eq("pk.lineNo", lineNo));
        memoToFile = (MemoToFile) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();

        return memoToFile;
    }

    public List<MemoToFile> findByFormNo(String formNo) {
        Session session = ClientInfoUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<MemoToFile> memoToFiles = new ArrayList<MemoToFile>();
        Criteria criteria = session.createCriteria(MemoToFile.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.addOrder(Order.asc("pk.lineNo"));
        memoToFiles = (List<MemoToFile>) criteria.list();
        session.getTransaction().commit();
        session.close();

        return memoToFiles;
    }
    
    public List<MemoToFile> findByFormNo(String formNo, Session session) {
        List<MemoToFile> memoToFiles = new ArrayList<MemoToFile>();
        Criteria criteria = session.createCriteria(MemoToFile.class);
        criteria.add(Restrictions.eq("pk.txFormNo", formNo));
        criteria.addOrder(Order.asc("pk.lineNo"));
        memoToFiles = (List<MemoToFile>) criteria.list();
       
        return memoToFiles;
    }
}
