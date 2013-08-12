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

    public List<Family> createNew(String fathersName, String fathersAddress, String fathersOccupation, int fathersAge,
            String mothersName, String mothersAddress, String mothersOccupation, int mothersAge, String personType, String formNo) {
        List<Family> results = new ArrayList<>();
        try {
            Family father = new Family();
            father.setFamName(fathersName);
            father.setFamAddress(fathersAddress);
            father.setFamOccupation(fathersOccupation);
            father.setFamAge(fathersAge);
            father.setFamRelation("FATHER");
            father.setPersonType(UISetting.getPersonTypeService().findById(personType));
            father.setTxForm(formNo);
            father.setUser(UISetting.getSystemUser());
            father.setLocation(UISetting.getStoreLocation());
            father.setStation(UISetting.getComputerName());
            
            boolean isFatherSaved = UISetting.getFamilyService().insert(father);
            if(isFatherSaved) {
                results.add(UISetting.getFamilyService().findById(formNo, personType, "FATHER"));
            }
            
            Family mother = new Family();
            mother.setFamName(mothersName);
            mother.setFamAddress(mothersAddress);
            mother.setFamOccupation(mothersOccupation);
            mother.setFamAge(mothersAge);
            mother.setFamRelation("MOTHER");
            mother.setPersonType(UISetting.getPersonTypeService().findById(personType));
            mother.setTxForm(formNo);
            mother.setUser(UISetting.getSystemUser());
            mother.setLocation(UISetting.getStoreLocation());
            mother.setStation(UISetting.getComputerName());
            
            boolean isMotherSaved = UISetting.getFamilyService().insert(mother);
            if(isMotherSaved) {
                results.add(UISetting.getFamilyService().findById(formNo, personType, "MOTHER"));
            }
        } catch (Exception ex) {
            UIValidator.log(ex, FamilyBackgroundController.class);
        }
        return results;
    }
    
    public List<Family> update(Family father, Family mother) {
        List<Family> results = new ArrayList<>();
        try {
            boolean isFatherUpdated = UISetting.getFamilyService().update(father);
            boolean isMotherUpdated = UISetting.getFamilyService().update(mother);
            if(isFatherUpdated) {
                results.add(UISetting.getFamilyService().findById(father.getTxFormNo(), father.getPersonType().getTypeID(), "FATHER"));
            }
            if(isMotherUpdated) {
                results.add(UISetting.getFamilyService().findById(mother.getTxFormNo(), mother.getPersonType().getTypeID(), "MOTHER"));
            }
        } catch (Exception e) {
            UIValidator.log(e, FamilyBackgroundController.class);
        }
        return results;
    }
}
