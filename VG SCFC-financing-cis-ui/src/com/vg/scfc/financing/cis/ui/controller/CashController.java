/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Customer;
import com.vg.scfc.financing.cis.ent.CustomerCashInfo;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodel
 */
public class CashController {

    private static CashController instance;

    public static CashController getInstance() {
        if (instance == null) {
            instance = new CashController();
        }
        return instance;
    }

    public List<CustomerCashInfo> findBySearchCriteria(String criteria) {
        List<CustomerCashInfo> results = new ArrayList<>();
        try {
            results = UISetting.getCustomerCashInfoService().findByCodeString(criteria, UISetting.getStoreLocation().getFinStartCode());
        } catch (Exception ex) {
            UIValidator.log(ex, CashController.class);
        }
        return results;
    }

    public CustomerCashInfo findByClientNo(String clientNo) {
        CustomerCashInfo result = null;
        try {
            result = UISetting.getCustomerCashInfoService().findById(clientNo);
        } catch (Exception ex) {
            UIValidator.log(ex, CashController.class);
        }
        return result;
    }

    public CustomerCashInfo save(CustomerCashInfo c) {
        CustomerCashInfo result = null;
        try {
            Customer cashCustomer = new Customer();
            cashCustomer.setName(c.getProperName());
            cashCustomer.setTransactionMode(UISetting.getTransactionModeService().findByID(1));
            cashCustomer.setUser(UISetting.getSystemUser());
            cashCustomer.setLocation(UISetting.getStoreLocation());
            cashCustomer.setStation(UISetting.getComputerName());

            c.setUser(UISetting.getSystemUser());
            c.setLocation(UISetting.getStoreLocation());
            c.setStation(UISetting.getComputerName());

            CustomerCashInfo savedCust = UISetting.getCustomerService().insert(cashCustomer, c);
            if (savedCust != null) {
                result = savedCust;
            }
        } catch (Exception ex) {
            UIValidator.log(ex, CashController.class);
        }
        return result;
    }

    public CustomerCashInfo update(CustomerCashInfo c) {
        CustomerCashInfo result = null;
        try {
            Customer cashCustomer = SearchController.getInstance().findCustomerByClientNo(c.getClientNo());
            cashCustomer.setUser(UISetting.getSystemUser());
            cashCustomer.setLocation(UISetting.getStoreLocation());
            cashCustomer.setStation(UISetting.getComputerName());
            
            c.setUser(UISetting.getSystemUser());
            c.setLocation(UISetting.getStoreLocation());
            c.setStation(UISetting.getComputerName());
            boolean isUpdated = UISetting.getCustomerService().update(cashCustomer, c);
            if (isUpdated) {
                result = findByClientNo(c.getClientNo());
            }  else {
                System.out.println("Error");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            UIValidator.log(ex, CashController.class);
        }
        return result;
    }

}
