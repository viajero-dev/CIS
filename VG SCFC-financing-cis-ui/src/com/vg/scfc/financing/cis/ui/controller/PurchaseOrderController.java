/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.PurchaseOrder;
import com.vg.scfc.financing.cis.service.PurchaseOrderService;
import java.math.BigDecimal;

/**
 *
 * @author rodel
 */
public class PurchaseOrderController {

    private static PurchaseOrderController instance;

    public static PurchaseOrderController getInstance() {
        if (instance == null) {
            instance = new PurchaseOrderController();
        }
        return instance;
    }
    
    public Object createNew(String unitApplied, BigDecimal downpayment, BigDecimal insurance, int term, BigDecimal amortization, boolean isBrandNew, String purpose, String remarks, String status) {
        PurchaseOrder po = new PurchaseOrder();
        po.setUnitApplied(unitApplied);
        po.setDownPayment(downpayment.doubleValue());
        po.setInsurance(insurance.doubleValue());
        po.setTerm(term);
        po.setMonthlyAmortization(amortization.doubleValue());
        po.setBrandNew(isBrandNew);
        po.setPurpose(purpose);
        po.setRemarks(remarks);
        po.setStatus(status);
        
        return new Object();
    }
    
    public Object update() {
        return new Object();
    }

}
