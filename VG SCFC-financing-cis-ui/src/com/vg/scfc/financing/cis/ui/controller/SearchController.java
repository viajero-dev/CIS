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
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public List<Customer> findBySearchCriteria(String criteria) {
        List<Customer> results = new ArrayList<>();
        try {
            results = UISetting.getCustomerService().filterBy(criteria, 2);
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
}
