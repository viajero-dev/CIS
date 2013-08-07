/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Family;
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

    public List<Object> createNew(String fathersName, String fathersAddress, String fathersOccupation, int fathersAge, String mothersName, String mothersAddress, String mothersOccupation, int mothersAge) {
        Family father = new Family();
        father.setFamName(fathersName);
        father.setFamAddress(fathersAddress);
        father.setFamOccupation(fathersOccupation);
//        father.setFamAge(fathersAge);
        father.setFamRelation("FATHER");
        
        Family mother = new Family();
        mother.setFamName(mothersName);
        mother.setFamAddress(mothersAddress);
        mother.setFamOccupation(mothersOccupation);
//        mother.setFamAge(mothersAge);
        mother.setFamRelation("MOTHER");
        
        return new ArrayList<>();
    }
    
    public List<Object> update(String clientNo, String fathersName, String fathersAddress, String fathersOccupation, int fathersAge, String mothersName, String mothersAddress, String mothersOccupation, int mothersAge) {
        return new ArrayList<>();
    }
}
