/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.CharacterReference;
import com.vg.scfc.financing.cis.ent.Dependent;

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
    
    public Object createNew(String name, String address, String contact, String relationship, boolean isDependent) {
        if(isDependent) {
            Dependent d = new Dependent();
            d.setDepName(name);
            d.setDepAddress(address);
            d.setDepContactNo(contact);
            d.setDepRelation(relationship);
        } else {
            CharacterReference chr = new CharacterReference();
            chr.setCharRefName(name);
            chr.setCharRefAddress(address);
            chr.setCharRefContactNo(contact);
//            chr.setRelationShip();
        }
        
        return new Object();
    }
    
    public Object update(String formNo, String name, String address, String contact, String relationship, boolean isDependent) {
        if(isDependent) {
            
        } else {
            
        }
        
        return new Object();
    }

}
