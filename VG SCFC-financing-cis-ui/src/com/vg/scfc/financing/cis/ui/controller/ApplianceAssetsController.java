/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Appliance;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    public List<Appliance> createNew(String type, BigDecimal estimatedValue, String formNo) {
        List<Appliance> results = new ArrayList<>();
        try {
            Appliance a = new Appliance();
            a.setType(type);
            a.setAmount(estimatedValue.doubleValue());
            a.setUser(UISetting.getSystemUser());
            a.setLocation(UISetting.getStoreLocation());
            a.setStation(UISetting.getComputerName());
            UISetting.getApplianceService().insert(formNo, a);
            results = UISetting.getApplianceService().findByAsset(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, ApplianceAssetsController.class);
        }
        return results;
    }

    public List<Appliance> update(String formNo, Appliance a) {
        List<Appliance> results = new ArrayList<>();
        try {
            UISetting.getApplianceService().update(a);
            results = UISetting.getApplianceService().findByAsset(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, ApplianceAssetsController.class);
        }
        return results;
    }
    
    public List<Appliance> findAll(String formNo) {
        List<Appliance> results = new ArrayList<>();
        try {
            UISetting.getApplianceService().findByAsset(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, ApplianceAssetsController.class);
        }
        return results;
    }

}
