/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Machinery;
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
public class MachineryAssetsController {

    private static MachineryAssetsController instance;

    public static MachineryAssetsController getInstance() {
        if (instance == null) {
            instance = new MachineryAssetsController();
        }
        return instance;
    }

    public List<Machinery> createNew(String type, int qty, BigDecimal estimatedValue, String formNo) {
        List<Machinery> results = new ArrayList<>();
        try {
            Machinery m = new Machinery();
            m.setType(type);
            m.setQuantity(qty);
            m.setAmount(estimatedValue.doubleValue());
            m.setUser(UISetting.getSystemUser());
            m.setLocation(UISetting.getStoreLocation());
            m.setStation(UISetting.getComputerName());
//            UISetting.getMachineryService().insert(formNo, m);
            results = UISetting.getMachineryService().findByAsset(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, MachineryAssetsController.class);
        }
        return results;
    }

    public List<Machinery> update(String formNo, Machinery m) {
        List<Machinery> results = new ArrayList<>();
        try {
//            UISetting.getMachineryService().update(m);
            results = UISetting.getMachineryService().findByAsset(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, MachineryAssetsController.class);
        }
        return results;
    }
    
    public List<Machinery> findAll(String formNo) {
        List<Machinery> results = new ArrayList<>();
        try {
            results = UISetting.getMachineryService().findByAsset(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, MachineryAssetsController.class);
        }
        return results;
    }

}
