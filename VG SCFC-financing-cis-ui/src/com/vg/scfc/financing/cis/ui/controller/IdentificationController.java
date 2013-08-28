/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Identification;
import com.vg.scfc.financing.cis.ent.PersonType;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;

/**
 *
 * @author rodel
 */
public class IdentificationController {

    private static IdentificationController instance;

    public static IdentificationController getInstance() {
        if (instance == null) {
            instance = new IdentificationController();
        }
        return instance;
    }
    
    public Identification save(String formNo, String personTypeID, Identification i) {
        Identification result = null;
        try {
            i.setTxFormNo(formNo);
            PersonType ptype = UISetting.getPersonTypeService().findById(personTypeID);
            i.setPersonType(ptype);
            i.setUser(UISetting.getSystemUser());
            i.setLocation(UISetting.getStoreLocation());
            i.setStation(UISetting.getComputerName());
            boolean isSaved = UISetting.getIdentificationService().insert(i);
            if(isSaved) {
                result = UISetting.getIdentificationService().findById(formNo, personTypeID);
            } 
        } catch (Exception ex) {
            UIValidator.log(ex, IdentificationController.class);
        }
        return result;
    }
    
    public Identification update(String formNo, String personTypeID, Identification i) {
        Identification result = null;
        try {
            i.setUser(UISetting.getSystemUser());
            i.setLocation(UISetting.getStoreLocation());
            i.setStation(UISetting.getComputerName());
            boolean isSaved = UISetting.getIdentificationService().update(i);
            if(isSaved) {
                result = UISetting.getIdentificationService().findById(formNo, personTypeID);
            } 
        } catch (Exception ex) {
            UIValidator.log(ex, IdentificationController.class);
        }
        return result;
    }
    
    public Identification findByFormNo(String formNo) {
        Identification result = null;
        try {
            result = UISetting.getIdentificationService().findById(formNo, "APP");
        } catch (Exception ex) {
            UIValidator.log(ex, IdentificationController.class);
        }
        return result;
    }
    
    public Identification findByFormNoAndPersonType(String formNo, String personTypeID) {
        Identification result = null;
        try {
            result = UISetting.getIdentificationService().findById(formNo, personTypeID);
        } catch (Exception ex) {
            UIValidator.log(ex, IdentificationController.class);
        }
        return result;
    }

}
