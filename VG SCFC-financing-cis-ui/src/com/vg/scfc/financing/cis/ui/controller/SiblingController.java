/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Sibling;

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

    public Object createNew(String name, String address, String contact) {
        Sibling s = new Sibling();
        s.setSiblingName(name);
        s.setSiblingAddress(address);
        s.setSiblingContactNo(contact);
        return new Object();
    }
    
    public Object update(String clientNo, String name, String address, String contact) {
        
        return new Object();
    }
}
