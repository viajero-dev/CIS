/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.CreditRef;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodel
 */
public class CreditReferenceController {

    private static CreditReferenceController instance;

    public static CreditReferenceController getInstance() {
        if (instance == null) {
            instance = new CreditReferenceController();
        }
        return instance;
    }
    
    public List<CreditRef> createNew(String name, String address, String itemOnCredit, BigDecimal loanAmount, BigDecimal monthlyAmort, String term, BigDecimal amountPaid, BigDecimal remainingBal, String formNo) {
        List<CreditRef> results = new ArrayList<>();
        try {
            CreditRef cr = new CreditRef();
            cr.setCreRefName(name);
            cr.setCreRefAddress(address);
            cr.setCreItem(itemOnCredit);
            cr.setCreRefLoanAmount(loanAmount.doubleValue());
            cr.setCreRefMonthly(monthlyAmort.doubleValue());
            cr.setCreRefTerm(term);
            cr.setCreRefAmountPaid(amountPaid.doubleValue());
            cr.setCreRefBalance(remainingBal.doubleValue());
            cr.setTxFormNo(formNo);
            cr.setUser(UISetting.getSystemUser());
            cr.setLocation(UISetting.getStoreLocation());
            cr.setStation(UISetting.getComputerName());
            
            boolean isSaved = UISetting.getCreditRefService().insert(cr);
            if(isSaved) {
                results = UISetting.getCreditRefService().findByFormNo(formNo);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, CreditReferenceController.class);
        }
        return results;
    }
    
    public List<CreditRef> update(String formNo, CreditRef c) {
        List<CreditRef> results = new ArrayList<>();
        try {
            boolean isUpdated = UISetting.getCreditRefService().update(c);
            if(isUpdated) {
                results = UISetting.getCreditRefService().findByFormNo(formNo);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, CreditReferenceController.class);
        }
        return results;
    }
    
    public List<CreditRef> findAll(String formNo) {
        List<CreditRef> results = new ArrayList<>();
        try {
            results = UISetting.getCreditRefService().findByFormNo(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, CreditReferenceController.class);
        }
        return results;
    }

}
