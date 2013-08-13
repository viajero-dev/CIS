/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.CreditRef;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodel
 */
public class CreditReferenceController {

    private static CreditReferenceController instance;

    public static CreditReferenceController getInstance() {
        if (instance == null) {
            instance = new CreditReferenceController();
        }
        return instance;
    }

    public List<CreditRef> createNew(CreditRef c, String formNo) {
        List<CreditRef> results = new ArrayList<>();
        try {
            c.setTxFormNo(formNo);
            c.setUser(UISetting.getSystemUser());
            c.setLocation(UISetting.getStoreLocation());
            c.setStation(UISetting.getComputerName());

            boolean isSaved = UISetting.getCreditRefService().insert(c);
            if (isSaved) {
                results = UISetting.getCreditRefService().findByFormNo(formNo);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, CreditReferenceController.class);
        }
        return results;
    }

    public List<CreditRef> update(String formNo, CreditRef c) {
        List<CreditRef> results = new ArrayList<>();
        try {
            c.setTxFormNo(formNo);
            c.setUser(UISetting.getSystemUser());
            c.setLocation(UISetting.getStoreLocation());
            c.setStation(UISetting.getComputerName());

            boolean isUpdated = UISetting.getCreditRefService().update(c);
            if (isUpdated) {
                results = UISetting.getCreditRefService().findByFormNo(formNo);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, CreditReferenceController.class);
        }
        return results;
    }

    public List<CreditRef> findAll(String formNo) {
        List<CreditRef> results = new ArrayList<>();
        try {
            results = UISetting.getCreditRefService().findByFormNo(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, CreditReferenceController.class);
        }
        return results;
    }

}
