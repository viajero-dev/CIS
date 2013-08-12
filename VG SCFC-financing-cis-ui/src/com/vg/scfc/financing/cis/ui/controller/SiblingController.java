/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Sibling;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodel
 */
public class SiblingController {

    private static SiblingController instance;

    public static SiblingController getInstance() {
        if (instance == null) {
            instance = new SiblingController();
        }
        return instance;
    }

    public List<Sibling> createNew(Sibling s, String formNo) {
        List<Sibling> results = new ArrayList<>();
        try {
            s.setTxFormNo(formNo);
            s.setUser(UISetting.getSystemUser());
            s.setLocation(UISetting.getStoreLocation());
            s.setStation(UISetting.getComputerName());
            UISetting.getSiblingService().insert(s);
            results = UISetting.getSiblingService().findByFormNo(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, SiblingController.class);
        }
        return results;
    }
    
    public List<Sibling> update(String formNo, Sibling s) {
        List<Sibling> results = new ArrayList<>();
        try {
            UISetting.getSiblingService().update(s);
            results = UISetting.getSiblingService().findByFormNo(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, SiblingController.class);
        }
        return results;
    }
    
    public List<Sibling> findAll(String formNo) {
        List<Sibling> results = new ArrayList<>();
        try {
            results = UISetting.getSiblingService().findByFormNo(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, SiblingController.class);
        }
        return results;
    }
}
