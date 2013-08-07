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

    public Object createNew(String name, String address, String contact, String formNo) {
        Sibling result = null;
        try {
            Sibling s = new Sibling();
            s.setSiblingName(name);
            s.setSiblingAddress(address);
            s.setSiblingContactNo(contact);
            s.setTxFormNo(formNo);
            s.setUser(UISetting.getSystemUser());
            s.setLocation(UISetting.getStoreLocation());
            s.setStation(UISetting.getComputerName());
            result = UISetting.getSiblingService().insert(s);
        } catch (Exception ex) {
            UIValidator.log(ex, SiblingController.class);
        }
        return result;
    }
    
    public Object update(String formNo, Sibling s) {
        Sibling result = null;
        try {
            result = UISetting.getSiblingService().update(s);
        } catch (Exception ex) {
            UIValidator.log(ex, SiblingController.class);
        }
        return result;
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
