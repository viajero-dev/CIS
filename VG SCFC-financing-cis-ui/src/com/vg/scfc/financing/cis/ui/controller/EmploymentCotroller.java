/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Employment;

/**
 *
 * @author rodel
 */
public class EmploymentCotroller {

    private static EmploymentCotroller instance;

    public static EmploymentCotroller getInstance() {
        if (instance == null) {
            instance = new EmploymentCotroller();
        }
        return instance;
    }
    
    public Object createNew(String status, String positionDept, String companyEmployer, String address, String contactNo, String natureOfBuss, int yearsInService) {
        Employment e = new Employment();
        e.setEmpStatus(status);
        e.setEmpPosition(positionDept);
        e.setEmpCompany(companyEmployer);
        e.setEmpAddress(address);
        e.setEmpContactNo(contactNo);
        e.setEmpNature(status);
//        e.setEmpYearsInService();
        
        return new Object();
    }
    
    public Object update(String clientNo, String status, String positionDept, String companyEmployer, String address, String contactNo, String natureOfBuss, int yearsInService) {
        return new Object();
    }

}
