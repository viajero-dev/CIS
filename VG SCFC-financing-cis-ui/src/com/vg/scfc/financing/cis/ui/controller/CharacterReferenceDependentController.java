/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.CharacterReference;
import com.vg.scfc.financing.cis.ent.Dependent;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodel
 */
public class CharacterReferenceDependentController {

    private static CharacterReferenceDependentController instance;

    public static CharacterReferenceDependentController getInstance() {
        if (instance == null) {
            instance = new CharacterReferenceDependentController();
        }
        return instance;
    }

    public List<CharacterReference> addCharacterReference(CharacterReference c, String formNo) {
        List<CharacterReference> results = new ArrayList<>();
        try {
            c.setTxFormNo(formNo);
            c.setUser(UISetting.getSystemUser());
            c.setLocation(UISetting.getStoreLocation());
            c.setStation(UISetting.getComputerName());
            boolean isSaved = UISetting.getCharacterReferenceService().insert(c);
            if (isSaved) {
                results = UISetting.getCharacterReferenceService().findByFormNo(formNo);
            }
        } catch (Exception e) {
            UIValidator.log(e, CharacterReferenceDependentController.class);
        }
        return results;
    }

    public List<Dependent> addDependent(Dependent d, String formNo) {
        List<Dependent> results = new ArrayList<>();
        try {
            d.setTxFormNo(formNo);
            d.setUser(UISetting.getSystemUser());
            d.setLocation(UISetting.getStoreLocation());
            d.setStation(UISetting.getComputerName());
            boolean isSaved = UISetting.getDependentService().insert(d);
            if (isSaved) {
                results = UISetting.getDependentService().findByFormNo(formNo);
            }
        } catch (Exception e) {
            UIValidator.log(e, CharacterReferenceDependentController.class);
        }
        return results;
    }

    public List<CharacterReference> updateCharacterReference(String formNo, CharacterReference c) {
        List<CharacterReference> results = new ArrayList<>();
        try {
            c.setTxFormNo(formNo);
            c.setUser(UISetting.getSystemUser());
            c.setLocation(UISetting.getStoreLocation());
            c.setStation(UISetting.getComputerName());
            
            boolean isUpdated = UISetting.getCharacterReferenceService().update(c);
            if (isUpdated) {
                results = UISetting.getCharacterReferenceService().findByFormNo(formNo);
            }
        } catch (Exception e) {
            UIValidator.log(e, CharacterReferenceDependentController.class);
        }
        return results;
    }

    public List<Dependent> updateDependent(String formNo, Dependent d) {
        List<Dependent> results = new ArrayList<>();
        try {
            d.setTxFormNo(formNo);
            d.setUser(UISetting.getSystemUser());
            d.setLocation(UISetting.getStoreLocation());
            d.setStation(UISetting.getComputerName());
            boolean isUpdated = UISetting.getDependentService().update(d);
            if (isUpdated) {
                results = UISetting.getDependentService().findByFormNo(formNo);
            }
        } catch (Exception e) {
            UIValidator.log(e, CharacterReferenceDependentController.class);
        }
        return results;
    }
    
    public List<CharacterReference> findCharacterReferencesByFormNo(String formNo) {
        List<CharacterReference> results = new ArrayList<>();
        try {
            results = UISetting.getCharacterReferenceService().findByFormNo(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, CharacterReferenceDependentController.class);
        }
        return results;
    }
    
    public List<Dependent> findDependentsByFormNo(String formNo) {
        List<Dependent> results = new ArrayList<>();
        try {
            results = UISetting.getDependentService().findByFormNo(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, CharacterReferenceDependentController.class);
        }
        return results;
    }

}
