/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.hrm.user.util;

import org.hibernate.SessionFactory;

/**
 *
 * @author raffy
 */
public class HrmUserUtil {
    
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        HrmUserUtil.sessionFactory = sessionFactory;
    }    
}
