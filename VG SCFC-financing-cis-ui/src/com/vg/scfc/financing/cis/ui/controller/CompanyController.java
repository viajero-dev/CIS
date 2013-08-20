/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Company;
import com.vg.scfc.financing.cis.ent.Customer;
import com.vg.scfc.financing.cis.ent.TransactionForm;
import com.vg.scfc.financing.cis.ent.TransactionMode;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.util.Date;

/**
 *
 * @author rodel
 */
public class CompanyController {

    private static CompanyController instance;

    public static CompanyController getInstance() {
        if (instance == null) {
            instance = new CompanyController();
        }
        return instance;
    }

    public Company createNew(Company c, String formSeries, Date applicationDate, String companyName) {
        Company result = null;
        try {
            /* Form Info */
            TransactionForm form = new TransactionForm();
            form.setTxApplicationDate(applicationDate);
            form.setUser(UISetting.getSystemUser());
            form.setStation(UISetting.getComputerName());
            form.setLocation(UISetting.getStoreLocation());
            form.setFormNo(formSeries);

            /* Transaction Mode */
            TransactionMode transactionMode = UISetting.getTransactionModeService().findByID(3);

            /* Customer Info */
            Customer customer = new Customer();
            customer.setName(companyName);
            customer.setTransactionMode(transactionMode);
            customer.setUser(UISetting.getSystemUser());
            customer.setLocation(UISetting.getStoreLocation());
            customer.setStation(UISetting.getComputerName());

            /* Institution Info */
            c.setUser(UISetting.getSystemUser());
            c.setLocation(UISetting.getStoreLocation());
            c.setStation(UISetting.getComputerName());

            /* Save Customer, Transaction Type & Company */
            String formResult = UISetting.getCustomerService().insert(customer, form, c);
            if (!formResult.equals("")) {
                result = UISetting.getCompanyService().findByFormNo(formResult);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, CompanyController.class);
        }

        return result;
    }

    public Company update(Company c) {
        Company result = null;
        try {
            TransactionForm form = UISetting.getTransactionFormService().findByformNo(c.getTxFormNo());
            Customer customer = UISetting.getCustomerService().findById(form.getClientNo());
            
            c.setUser(UISetting.getSystemUser());
            c.setLocation(UISetting.getStoreLocation());
            c.setStation(UISetting.getComputerName());
            boolean isUpdated = UISetting.getCustomerService().update(customer, c);
            if (isUpdated) {
                result = UISetting.getCompanyService().findByFormNo(form.getTxFormNo());
            } else {
                System.out.println("error on update...");
            }
        } catch (Exception e) {
            UIValidator.log(e, CompanyController.class);
        }
        return result;
    }

    public Object findByFormNo(String formNo) {
        Object result = null;
        try {
            result = UISetting.getCompanyService().findByFormNo(formNo);
        } catch (Exception e) {
            UIValidator.log(e, CompanyController.class);
        }
        return result;
    }

}
