/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.CreditRef;
import java.math.BigDecimal;

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
    
    public Object createNew(String name, String address, String itemOnCredit, BigDecimal loanAmount, BigDecimal monthlyAmort, String term, BigDecimal amountPaid, BigDecimal remainingBal) {
        CreditRef cr = new CreditRef();
        cr.setCreRefName(name);
        cr.setCreRefAddress(address);
        //set Item on Credit
        cr.setCreRefLoanAmount(loanAmount.doubleValue());
        cr.setCreRefMonthly(monthlyAmort.doubleValue());
        cr.setCreRefTerm(term);
        cr.setCreRefAmountPaid(amountPaid.doubleValue());
        cr.setCreRefBalance(remainingBal.doubleValue());
        return new Object();
    }
    
    public Object update(String formNo,String name, String address, String itemOnCredit, BigDecimal loanAmount, BigDecimal monthlyAmort, String term, BigDecimal amountPaid, BigDecimal remainingBal) {
        return new Object();
    }

}
