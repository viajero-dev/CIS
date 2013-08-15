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

    public List<Appliance> createNew(String formNo, Appliance a) {
        List<Appliance> results = new ArrayList<>();
        try {
            a.setUser(UISetting.getSystemUser());
            a.setLocation(UISetting.getStoreLocation());
            a.setStation(UISetting.getComputerName());
            Appliance x = UISetting.getApplianceService().insert(formNo, a);
            if(x ==null) {
                System.out.println("Error on save");
            }
            results = UISetting.getApplianceService().findByAsset(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, ApplianceAssetsController.class);
        }
        return results;
    }

    public List<Appliance> update(String formNo, Appliance a) {
        List<Appliance> results = new ArrayList<>();
        try {
            a.setUser(UISetting.getSystemUser());
            a.setLocation(UISetting.getStoreLocation());
            a.setStation(UISetting.getComputerName());
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
            results = UISetting.getApplianceService().findByAsset(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, ApplianceAssetsController.class);
        }
        return results;
    }

}
