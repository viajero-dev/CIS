/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Customer;
import com.vg.scfc.financing.cis.ent.TransactionForm;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodel
 */
public class SearchController {

    private static SearchController instance;

    public static SearchController getInstance() {
        if (instance == null) {
            instance = new SearchController();
        }
        return instance;
    }

    public List<Customer> findAll() {
        List<Customer> results = new ArrayList<>();
        try {
            results = UISetting.getCustomerService().findByTransactionMode(2);
            System.out.println("Results: " + results.size());
        } catch (Exception ex) {
            UIValidator.log(ex, SearchController.class);
        }
        return results;
    }

    public List<Customer> findAllWithLimit(int limit) {
        List<Customer> results = new ArrayList<>();
        try {
            List<Customer> tempResult = UISetting.getCustomerService().findByTransactionMode(2);
            int loopCounter = 1;
            for (Customer customer : tempResult) {
                if (loopCounter <= limit) {
                    results.add(customer);
                    loopCounter++;
                }
            }
        } catch (Exception ex) {
            UIValidator.log(ex, SearchController.class);
        }
        return results;
    }

    public List<Customer> findBySearchCriteria(String criteria) {
        List<Customer> results = new ArrayList<>();
        try {
            results = UISetting.getCustomerService().filterBy(criteria, 2);
        } catch (Exception ex) {
            UIValidator.log(ex, SearchController.class);
        }
        return results;
    }
    
    public List<Customer> findBySearchCriteriaLocationAndMode(String criteria, String location, int transactionMode) {
        List<Customer> results = new ArrayList<>();
        try {
            results = UISetting.getCustomerService().filterBy(location, transactionMode, criteria);
        } catch (Exception ex) {
            UIValidator.log(ex, SearchController.class);
        }
        return results;
    }

    public List<TransactionForm> findByClientNo(String clientNo) {
        List<TransactionForm> results = new ArrayList<>();
        try {
            results = UISetting.getTransactionFormService().findByClientNo(clientNo);
        } catch (Exception ex) {
            UIValidator.log(ex, SearchController.class);
        }
        return results;
    }

    public List<Customer> findByTransactionMode(int mode) {
        List<Customer> results = new ArrayList<>();
        try {
            results = UISetting.getCustomerService().findByTransactionMode(mode);
        } catch (Exception ex) {
            UIValidator.log(ex, SearchController.class);
        }
        return results;
    }
    
    public Customer findByFormNo(String formNo) {
        Customer result = null;
        try {
            TransactionForm form = FormController.getInstance().findByFormNo(formNo);
            result = UISetting.getCustomerService().findById(form.getClientNo());
        } catch (Exception ex) {
            UIValidator.log(ex, SearchController.class);
        }
        return result;
    }
}
