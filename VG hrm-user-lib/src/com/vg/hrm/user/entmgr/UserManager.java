/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.hrm.user.entmgr;

import com.vg.hrm.user.ent.User;
import com.vg.hrm.user.util.HrmUserUtil;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import sun.misc.BASE64Encoder;

/**
 *
 * @author raffy
 */
public class UserManager {
    
    private UserManager instance;

    public UserManager getInstance() {
        if(instance == null) instance = new UserManager();
        return instance;
    }

    public User findById(String id) {
        Session session = HrmUserUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        User user = (User) session.get(User.class, id);
        
        session.getTransaction().commit();
        session.close();
        return user;
    }
    
    public boolean validatePassword(String userId, byte[] encryptedPasswordByteArray) {        
        return true;
    }
    
    public String encrypt(String plainPassword,
            String algorithm, String encoding) throws Exception {
        MessageDigest msgDigest = null;
        String hashValue = null;
        try {
            msgDigest = MessageDigest.getInstance(algorithm);
            msgDigest.update(plainPassword.getBytes(encoding));
            byte rawByte[] = msgDigest.digest();
            hashValue = (new BASE64Encoder()).encode(rawByte); 
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm Exists");
        } catch (UnsupportedEncodingException e) {
            System.out.println("The Encoding Is Not Supported");
        }
        return hashValue;
    }

    public List<User> filterById(String searchString) {
        Session session = HrmUserUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        List<User> users = new ArrayList<>();
        Query query = session.getNamedQuery("User.AllIdLike");
        query.setString("id", "%" + searchString + "%");
        users = query.list();
        
        session.getTransaction().commit();
        session.close();
        
        return users;
    }   
    
    public boolean isExist(String employeeId) {
        Session session = HrmUserUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("FROM User u WHERE u.id = :empId");
        query.setParameter("empId", employeeId);
        User user = (User) query.uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        
        if(user != null) {
            if(!user.getNewPassword().isEmpty()) return true;
        }

        return false;
    }
    
    public List<User> getAll() {
        Session session = HrmUserUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("FROM User");
        List<User> users = query.list();
        
        session.getTransaction().commit();
        session.close();
        
        return users;
    }
}
