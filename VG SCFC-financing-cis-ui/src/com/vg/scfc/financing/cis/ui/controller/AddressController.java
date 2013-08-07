/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Address;
import java.util.ArrayList;
import java.util.List;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;

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

    public Object createNew(String brgyCode, String zipCode, String street, String description, String status, int yearsOfStay) {
        Object result = null;
        Address a = new Address();
        a.setBrgyCode(brgyCode);
        a.setZipCode(zipCode);
        a.setAddress(street);
        a.setDescription(description);
        a.setStatus(status);
        a.setYearsOfStay(yearsOfStay + "");
        
        try {
            boolean isSaved = UISetting.getAddressService().insert(a);
            if(isSaved) {
                result = UISetting.getAddressService().findById("");
            }
        } catch (Exception ex) {
            UIValidator.log(ex, AddressController.class);
        }

        return result;
    }

    public Object update(Address a) {
        return new Object();
    }

    public List<Address> findByFormNo(String formNo) {
        return new ArrayList<>();
    }
}
