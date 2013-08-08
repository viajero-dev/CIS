/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.commons.util.DateUtil;
import com.vg.scfc.financing.cis.ent.PurchaseOrder;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public PurchaseOrder createNew(String unitApplied, BigDecimal downpayment, BigDecimal insurance, int term, 
            BigDecimal amortization, boolean isBrandNew, String purpose, String remarks, String status, String formNo) {
        PurchaseOrder result = null;
        PurchaseOrder po = new PurchaseOrder();
        po.setEncodeDate(DateUtil.now());
        po.setUnitApplied(unitApplied);
        po.setDownPayment(downpayment.doubleValue());
        po.setInsurance(insurance.doubleValue());
        po.setTerm(term);
        po.setMonthlyAmortization(amortization.doubleValue());
        po.setBrandNew(isBrandNew);
        po.setPurpose(purpose);
        po.setRemarks(remarks);
        po.setStatus(status);
        po.setTxFormNo(formNo);
        /* For trail & Liveupdate */
        po.setLocation(UISetting.getStoreLocation());
        po.setStation(UISetting.getComputerName());
        po.setUser(UISetting.getSystemUser());
        
        try {
            result = UISetting.getPurchaseOrderService().insert(po);
        } catch (Exception ex) {
            UIValidator.log(ex, PurchaseOrderController.class);
        }
        
        return result;
    }
    
    public PurchaseOrder update(String formNo, PurchaseOrder p) {
        PurchaseOrder result = null;
        try {
            result = UISetting.getPurchaseOrderService().update(p);
        } catch (Exception ex) {
            UIValidator.log(ex, PurchaseOrderController.class);
        }
        return result;
    }
    
    public Object findByFormNo(String formNo) {
        Object result = null;
        try {
            result = UISetting.getPurchaseOrderService().findByTransNo(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, PurchaseOrderController.class);
        }
        return result;
    }

}
