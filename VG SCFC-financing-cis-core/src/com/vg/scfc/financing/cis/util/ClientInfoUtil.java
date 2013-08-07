/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.util;

import com.vg.hrm.user.ent.Employee;
import com.vg.hrm.user.ent.User;
import com.vg.scfc.financing.commons.ent.AuditTrail;
import com.vg.scfc.financing.commons.ent.LiveUpdate;
import com.vg.scfc.financing.commons.ent.Location;
import com.vg.scfc.financing.commons.ent.UpdateSetting;
import com.vg.scfc.financing.commons.value.ConnectionProperties;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author raffy
 */
public class ClientInfoUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration()
                    .configure("cis.cfg.xml")
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:mysql://" +
                                 ConnectionProperties.getServer() + ":3306/" + ConnectionProperties.getDatabase())
                    .setProperty("hibernate.connection.username", ConnectionProperties.getUserName())
                    .setProperty("hibernate.connection.password", ConnectionProperties.getPassWord())
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Location.class)
                    .addAnnotatedClass(AuditTrail.class)
                    .addAnnotatedClass(LiveUpdate.class)
                    .addAnnotatedClass(UpdateSetting.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
