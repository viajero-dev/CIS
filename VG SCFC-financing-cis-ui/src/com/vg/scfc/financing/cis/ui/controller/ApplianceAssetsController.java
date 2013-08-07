/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Appliance;
import java.math.BigDecimal;

/**
 *
 * @author rodel
 */
public class ApplianceAssetsController {

    private static ApplianceAssetsController instance;

    public static ApplianceAssetsController getInstance() {
        if (instance == null) {
            instance = new ApplianceAssetsController();
        }
        return instance;
    }
    
    public Object createNew(String type, BigDecimal estimatedValue) {
        Appliance a = new Appliance();
        a.setType(type);
        a.setAmount(estimatedValue.doubleValue());
        return new Object();
    }
    
    public Object update(String formNo, String type, BigDecimal estimatedValue) {
        return new Object();
    }

}
