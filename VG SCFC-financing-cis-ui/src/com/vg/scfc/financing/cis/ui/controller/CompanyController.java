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

    public Object createNew(String president, String address, String natureOfBusiness, int yearOfService, String contactNo, String tin, String email, String businessPermitNo, Date issuedDate, Date expirationDate, String formSeries, Date applicationDate, String companyName) {
        Object result = null;
        try {
            /* Form Info */
            TransactionForm form = new TransactionForm();
            String formNo = FormController.getInstance().newFormNo(UISetting.getStoreLocation().getId(), "02", formSeries);
            form.setTxFormNo(formNo);
            form.setTxApplicationDate(applicationDate);
            form.setUser(UISetting.getSystemUser());
            form.setStation(UISetting.getComputerName());
            form.setLocation(UISetting.getStoreLocation());

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
            Company company = new Company();
            company.setTxFormNo(formNo);
            company.setPresident(president);
            company.setAddress(address);
            company.setNatureOfBusiness(natureOfBusiness);
            company.setYearOfService(yearOfService);
            company.setContactNo(contactNo);
            company.setTin(tin);
            company.setEmail(email);
            company.setBusinessPermitNo(businessPermitNo);
            company.setIssuedDate(issuedDate);
            company.setExpirationDate(expirationDate);
            company.setUser(UISetting.getSystemUser());
            company.setLocation(UISetting.getStoreLocation());
            company.setStation(UISetting.getComputerName());

            /* Save Customer, Transaction Type & Company */
            boolean isSaved = UISetting.getCustomerService().insert(customer, form, company);
            if (isSaved) {
                result = UISetting.getCompanyService().findByFormNo(formNo);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, CompanyController.class);
        }

        return result;
    }

    public Object update(Company c) {
        Object result = null;
        try {
            TransactionForm form = UISetting.getTransactionFormService().findByformNo(c.getTxFormNo());
            Customer customer = UISetting.getCustomerService().findById(form.getClientNo());
            boolean isUpdated = UISetting.getCustomerService().update(customer, c);
            if (isUpdated) {
                result = UISetting.getCompanyService().findByFormNo(form.getTxFormNo());
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
