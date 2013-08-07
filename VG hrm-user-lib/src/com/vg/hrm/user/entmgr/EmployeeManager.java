/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.hrm.user.entmgr;

import com.vg.hrm.user.ent.Employee;
import com.vg.hrm.user.util.HrmUserUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author raffy
 */
public class EmployeeManager {

    private static EmployeeManager instance;
    
    public static EmployeeManager getInstance() {
        if (instance == null) instance = new EmployeeManager();
        return instance;
    }
   
    public Employee findById(String id) {
        Session session = HrmUserUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Employee employee = (Employee) session.get(Employee.class, id);
        
        session.getTransaction().commit();
        session.close();
        
        return employee;
    }
    
    public Employee findById(String id, Session session) {
        return (Employee) session.get(Employee.class, id);
    }
    
    public List<Employee> filterBy(String searchString) {
        Session session = HrmUserUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        List<Employee> employees = null;
        Criteria criteria = session.createCriteria(Employee.class);
        // on empty searchString
        if (searchString.trim().equals("")) {
            employees = criteria.list();
            
            session.getTransaction().commit();
            session.close();
            
            return employees;
        }
        
        StringTokenizer st = new StringTokenizer(searchString);
        if (st.countTokens() == 1) {
            criteria.add(Restrictions.or(Restrictions.like("id", "%" + searchString + "%"),
                    Restrictions.or(Restrictions.like("firstname", "%" + searchString + "%"),
                    Restrictions.or(Restrictions.like("middlename", "%" + searchString + "%"),
                    Restrictions.or(Restrictions.like("nickname", "%" + searchString + "%"),
                    Restrictions.like("lastname", "%" + searchString + "%"))))));
            employees = criteria.list();
            
            session.getTransaction().commit();
            session.close();
            
            return employees;
        }
        // if 2 or more tokens
        String token = st.nextToken();
        criteria = session.createCriteria(Employee.class);
        criteria.setProjection(Projections.property("id"))
                .add(Restrictions.or(Restrictions.like("id", "%" + token + "%"),
                    Restrictions.or(Restrictions.like("firstname", "%" + token + "%"),
                    Restrictions.or(Restrictions.like("middlename", "%" + token + "%"),
                    Restrictions.or(Restrictions.like("nickname", "%" + token + "%"),
                    Restrictions.like("lastname", "%" + token + "%"))))));
        List<String> ids = criteria.list();
        
        if(!ids.isEmpty()) {
            while (st.hasMoreTokens()) {            
                token = st.nextToken();
                
                criteria = session.createCriteria(Employee.class);
                criteria.setProjection(Projections.property("id"))
                    .add(Restrictions.or(Restrictions.like("id", "%" + token + "%"),
                        Restrictions.or(Restrictions.like("firstname", "%" + token + "%"),
                        Restrictions.or(Restrictions.like("middlename", "%" + token + "%"),
                        Restrictions.or(Restrictions.like("nickname", "%" + token + "%"),
                        Restrictions.like("lastname", "%" + token + "%"))))))
                    .add(Restrictions.in("id", ids));
                ids = criteria.list();
                
                if(ids.isEmpty()) { break; }
            }

            if(!ids.isEmpty()) {
                criteria = session.createCriteria(Employee.class);
                criteria.add(Restrictions.or(Restrictions.like("id", "%" + token + "%"),
                            Restrictions.or(Restrictions.like("firstname", "%" + token + "%"),
                            Restrictions.or(Restrictions.like("middlename", "%" + token + "%"),
                            Restrictions.or(Restrictions.like("nickname", "%" + token + "%"),
                            Restrictions.like("lastname", "%" + token + "%"))))))
                        .add(Restrictions.in("id", ids));
                employees = criteria.list();
            }
        }
        
        session.getTransaction().commit();
        session.close();
        
        return employees;
    }
    
    public List<Employee> filterBy(List<String> users, String searchString) {
        Session session = HrmUserUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        List<Employee> employees = null;
        Criteria criteria = session.createCriteria(Employee.class)
                .add(Restrictions.in("id", users));
        
        // on empty searchString
        if (searchString.trim().equals("")) {
            employees = criteria.list();
            
            session.getTransaction().commit();
            session.close();
            
            return employees;
        }
        
        StringTokenizer st = new StringTokenizer(searchString);
        if (st.countTokens() == 1) {
            criteria.add(Restrictions.or(Restrictions.like("id", "%" + searchString + "%"),
                    Restrictions.or(Restrictions.like("firstname", "%" + searchString + "%"),
                    Restrictions.or(Restrictions.like("middlename", "%" + searchString + "%"),
                    Restrictions.or(Restrictions.like("nickname", "%" + searchString + "%"),
                    Restrictions.like("lastname", "%" + searchString + "%"))))));
            employees = criteria.list();
            
            session.getTransaction().commit();
            session.close();
            
            return employees;
        }
        
        // if 2 or more tokens
        String token = st.nextToken();
        criteria = session.createCriteria(Employee.class);
        criteria.setProjection(Projections.property("id"))
                .add(Restrictions.or(Restrictions.like("id", "%" + token + "%"),
                    Restrictions.or(Restrictions.like("firstname", "%" + token + "%"),
                    Restrictions.or(Restrictions.like("middlename", "%" + token + "%"),
                    Restrictions.or(Restrictions.like("nickname", "%" + token + "%"),
                    Restrictions.like("lastname", "%" + token + "%"))))));
        List<String> ids = criteria.list();
        
        if(!ids.isEmpty()) {
            while (st.hasMoreTokens()) {            
                token = st.nextToken();
                
                criteria = session.createCriteria(Employee.class);
                criteria.setProjection(Projections.property("id"))
                    .add(Restrictions.or(Restrictions.like("id", "%" + token + "%"),
                        Restrictions.or(Restrictions.like("firstname", "%" + token + "%"),
                        Restrictions.or(Restrictions.like("middlename", "%" + token + "%"),
                        Restrictions.or(Restrictions.like("nickname", "%" + token + "%"),
                        Restrictions.like("lastname", "%" + token + "%"))))))
                    .add(Restrictions.in("id", ids));
                ids = criteria.list();
                
                if(ids.isEmpty()) { break; }
            }
            
            if(!ids.isEmpty()) {
                criteria = session.createCriteria(Employee.class);
                criteria.add(Restrictions.or(Restrictions.like("id", "%" + token + "%"),
                            Restrictions.or(Restrictions.like("firstname", "%" + token + "%"),
                            Restrictions.or(Restrictions.like("middlename", "%" + token + "%"),
                            Restrictions.or(Restrictions.like("nickname", "%" + token + "%"),
                            Restrictions.like("lastname", "%" + token + "%"))))))
                        .add(Restrictions.in("id", ids));
                employees = criteria.list();
            }
        }
        
        session.getTransaction().commit();
        session.close();
        
        return employees;
    }
    
    public List<Employee> getAll() {
        Session session = HrmUserUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        List<Employee> employees = new ArrayList<>();
        Criteria criteria = session.createCriteria(Employee.class);
        employees = criteria.list();
        
        session.getTransaction().commit();
        session.close();
        
        return employees;
    }
    
}
