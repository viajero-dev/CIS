/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Vehicle;
import java.math.BigDecimal;

/**
 *
 * @author rodel
 */
public class VehicleAssetsController {

    private static VehicleAssetsController instance;

    public static VehicleAssetsController getInstance() {
        if (instance == null) {
            instance = new VehicleAssetsController();
        }
        return instance;
    }
    
    public Object createNew(String type, int age, String use, BigDecimal amount) {
        Vehicle v = new Vehicle();
        v.setType(type);
        v.setAge(age);
        v.setUse(use);
        v.setAmount(amount.doubleValue());
        return new Object();
    }
    
    public Object update(String formNo, String type, int age, String use, BigDecimal amount) {
        return new Object();
    }

}
