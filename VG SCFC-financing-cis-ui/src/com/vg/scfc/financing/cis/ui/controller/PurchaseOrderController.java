/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.PurchaseOrder;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
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

    public PurchaseOrder save(String formNo, PurchaseOrder p) {
        PurchaseOrder result = null;
        p.setTxFormNo(formNo);
        p.setLocation(UISetting.getStoreLocation());
        p.setStation(UISetting.getComputerName());
        p.setUser(UISetting.getSystemUser());
        try {
            result = UISetting.getPurchaseOrderService().insert(p);
        } catch (Exception ex) {
            UIValidator.log(ex, PurchaseOrderController.class);
        }
        return result;
    }

    public PurchaseOrder update(String formNo, PurchaseOrder p) {
        PurchaseOrder result = null;
        try {
            p.setTxFormNo(formNo);
            p.setLocation(UISetting.getStoreLocation());
            p.setStation(UISetting.getComputerName());
            p.setUser(UISetting.getSystemUser());
            result = UISetting.getPurchaseOrderService().update(p);
        } catch (Exception ex) {
            UIValidator.log(ex, PurchaseOrderController.class);
        }
        return result;
    }

    public PurchaseOrder findByFormNo(String formNo) {
        PurchaseOrder result = null;
        try {
            result = UISetting.getPurchaseOrderService().findByTransNo(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, PurchaseOrderController.class);
        }
        return result;
    }
    
    public double computePrice(BigDecimal ma, BigDecimal term) {
        return ma.multiply(term).doubleValue();
    }
    
    public double computeBalance(BigDecimal price, BigDecimal downpayment) {
        return price.subtract(downpayment).doubleValue();
    }

}
