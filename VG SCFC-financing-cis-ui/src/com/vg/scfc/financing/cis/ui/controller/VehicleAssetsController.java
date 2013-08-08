/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Vehicle;
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
public class VehicleAssetsController {

    private static VehicleAssetsController instance;

    public static VehicleAssetsController getInstance() {
        if (instance == null) {
            instance = new VehicleAssetsController();
        }
        return instance;
    }

    public List<Vehicle> createNew(String type, int age, String use, BigDecimal amount, String formNo) {
        List<Vehicle> results = new ArrayList<>();
        try {
            Vehicle v = new Vehicle();
            v.setType(type);
            v.setAge(age);
            v.setUse(use);
            v.setAmount(amount.doubleValue());
            v.setUser(UISetting.getSystemUser());
            v.setLocation(UISetting.getStoreLocation());
            v.setStation(UISetting.getComputerName());
            UISetting.getVehicleService().insert(formNo, v);
            results = UISetting.getVehicleService().findByAsset(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, VehicleAssetsController.class);
        }
        return results;
    }

    public List<Vehicle> update(String formNo, Vehicle v) {
        List<Vehicle> results = new ArrayList<>();
        try {
            UISetting.getVehicleService().update(v);
            results = UISetting.getVehicleService().findByAsset(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, VehicleAssetsController.class);
        }
        return results;
    }

}
