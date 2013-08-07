/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Machinery;
import java.math.BigDecimal;

/**
 *
 * @author rodel
 */
public class MachineryAssetsController {

    private static MachineryAssetsController instance;

    public static MachineryAssetsController getInstance() {
        if (instance == null) {
            instance = new MachineryAssetsController();
        }
        return instance;
    }
    
    public Object createNew(String type, int qty, BigDecimal estimatedValue) {
        Machinery m = new Machinery();
        m.setType(type);
        m.setQuantity(qty);
        m.setAmount(estimatedValue.doubleValue());
        return new Object();
    }
    
    public Object update(String formNo, String type, int qty, BigDecimal estimatedValue) {
        return new Object();
    }

}
