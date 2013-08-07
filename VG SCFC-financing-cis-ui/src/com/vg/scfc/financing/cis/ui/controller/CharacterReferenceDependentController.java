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

    public List<CharacterReference> addCharacterReference(String name, String address, String contact, String relationship, String formNo) {
        List<CharacterReference> results = new ArrayList<>();
        try {
            CharacterReference chr = new CharacterReference();
            chr.setCharRefName(name);
            chr.setCharRefAddress(address);
            chr.setCharRefContactNo(contact);
            chr.setCharRelationship(relationship);
            chr.setTxFormNo(formNo);
            chr.setUser(UISetting.getSystemUser());
            chr.setLocation(UISetting.getStoreLocation());
            chr.setStation(UISetting.getComputerName());
            boolean isSaved = UISetting.getCharacterReferenceService().insert(chr);
            if (isSaved) {
                results = UISetting.getCharacterReferenceService().findByFormNo(formNo);
            }
        } catch (Exception e) {
            UIValidator.log(e, CharacterReferenceDependentController.class);
        }
        return results;
    }

    public List<Dependent> addDependent(String name, String address, String contact, String relationship, String formNo) {
        List<Dependent> results = new ArrayList<>();
        try {
            Dependent d = new Dependent();
            d.setDepName(name);
            d.setDepAddress(address);
            d.setDepContactNo(contact);
            d.setDepRelation(relationship);
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
            boolean isUpdated = UISetting.getCharacterReferenceService().update(c);
            if(isUpdated) {
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
            boolean isUpdated = UISetting.getDependentService().update(d);
            if(isUpdated) {
                results = UISetting.getDependentService().findByFormNo(formNo);
            }
        } catch (Exception e) {
            UIValidator.log(e, CharacterReferenceDependentController.class);
        }
        return results;
    }
    
}
