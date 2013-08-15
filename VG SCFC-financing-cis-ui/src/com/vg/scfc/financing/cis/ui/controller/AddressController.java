/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Address;
import com.vg.scfc.financing.cis.ent.PersonType;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodel
 */
public class AddressController {

    private static AddressController instance;

    public static AddressController getInstance() {
        if (instance == null) {
            instance = new AddressController();
        }
        return instance;
    }

    public List<Address> createNew(String formNo, String personType, Address a) {
        List<Address> results = new ArrayList<>();
        try {
            PersonType p = UISetting.getPersonTypeService().findById(personType);
            System.out.println(p == null);
            a.setPersonType(p);
            a.setTxFormNo(formNo);
            a.setUser(UISetting.getSystemUser());
            a.setLocation(UISetting.getStoreLocation());
            a.setStation(UISetting.getComputerName());
            boolean isSaved = UISetting.getAddressService().insert(a);
            if (isSaved) {
                results = UISetting.getAddressService().filterBy(formNo, personType);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, AddressController.class);
        }
        return results;
    }

    public Object update(Address a) {
        return new Object();
    }

    public List<Address> findByFormNo(String formNo, String personType) {
        List<Address> results = new ArrayList<>();
        try {
            results = UISetting.getAddressService().filterBy(formNo, personType);
        } catch (Exception ex) {
            UIValidator.log(ex, AddressController.class);
        }
        return results;
    }
}
