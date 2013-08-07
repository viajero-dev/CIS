/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jp
 */
public class CommonsUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        CommonsUtil.sessionFactory = sessionFactory;
    }
}
