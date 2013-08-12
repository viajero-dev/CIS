/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Family;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodel
 */
public class FamilyBackgroundController {

    private static FamilyBackgroundController instance;

    public static FamilyBackgroundController getInstance() {
        if (instance == null) {
            instance = new FamilyBackgroundController();
        }
        return instance;
    }

    public List<Family> createNew(List<Family> families, String personType, String formNo) {
        List<Family> results = new ArrayList<>();
        try {
            boolean hasError = false;
            for (Family family : families) {
                family.setPersonType(UISetting.getPersonTypeService().findById(personType));
                family.setTxForm(formNo);
                family.setUser(UISetting.getSystemUser());
                family.setLocation(UISetting.getStoreLocation());
                family.setStation(UISetting.getComputerName());

                boolean isSaved = UISetting.getFamilyService().insert(family);
                if (!isSaved) {
                    hasError = true;
                    break;
                }
            }

            if (!hasError) {
                results = UISetting.getFamilyService().findById(formNo, personType);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, FamilyBackgroundController.class);
        }
        return results;
    }

    public List<Family> update(List<Family> families, String formNo, String personType) {
        List<Family> results = new ArrayList<>();
        try {
            boolean hasError = false;
            for (Family family : families) {
                family.setPersonType(UISetting.getPersonTypeService().findById(personType));
                family.setTxForm(formNo);
                family.setUser(UISetting.getSystemUser());
                family.setLocation(UISetting.getStoreLocation());
                family.setStation(UISetting.getComputerName());

                boolean isUpdated = UISetting.getFamilyService().update(family);
                if (!isUpdated) {
                    System.out.println("oopss... something went wrong.");
                    hasError = true;
                    break;
                }
            }

            if (!hasError) {
                results = UISetting.getFamilyService().findById(formNo, personType);
            }
        } catch (Exception e) {
            e.printStackTrace();
            UIValidator.log(e, FamilyBackgroundController.class);
        }
        return results;
    }
}
