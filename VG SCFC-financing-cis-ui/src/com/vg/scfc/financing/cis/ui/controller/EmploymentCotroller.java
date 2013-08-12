/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Employment;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;

/**
 *
 * @author rodel
 */
public class EmploymentCotroller {

    private static EmploymentCotroller instance;

    public static EmploymentCotroller getInstance() {
        if (instance == null) {
            instance = new EmploymentCotroller();
        }
        return instance;
    }

    public Object createNew(Employment e, String personType, String formNo) {
        Object result = null;
        try {
            e.setPersonType(UISetting.getPersonTypeService().findById(personType));
            e.setTxFormNo(formNo);
            e.setUser(UISetting.getSystemUser());
            e.setLocation(UISetting.getStoreLocation());
            e.setStation(UISetting.getComputerName());

            boolean isSaved = UISetting.getEmploymentService().insert(e);
            if (isSaved) {
                result = UISetting.getEmploymentService().findByFormNo(formNo);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, EmploymentCotroller.class);
        }
        return result;
    }

    public Object update(String formNo, Employment e) {
        Object result = null;
        try {
            boolean isUpdated = UISetting.getEmploymentService().update(e);
            if (isUpdated) {
                result = UISetting.getEmploymentService().findByFormNo(formNo);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, EmploymentCotroller.class);
        }
        return result;
    }

}
