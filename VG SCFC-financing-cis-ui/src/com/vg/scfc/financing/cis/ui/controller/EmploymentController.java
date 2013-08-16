/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Employment;
import com.vg.scfc.financing.cis.ent.RepresentativeEmployment;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodel
 */
public class EmploymentController {

    private static EmploymentController instance;

    public static EmploymentController getInstance() {
        if (instance == null) {
            instance = new EmploymentController();
        }
        return instance;
    }

    public Employment save(Employment e, String personType, String formNo) {
        Employment result = null;
        try {
            e.setPersonType(UISetting.getPersonTypeService().findById(personType));
            e.setTxFormNo(formNo);
            e.setUser(UISetting.getSystemUser());
            e.setLocation(UISetting.getStoreLocation());
            e.setStation(UISetting.getComputerName());

            boolean isSaved = UISetting.getEmploymentService().insert(e);
            if (isSaved) {
                result = UISetting.getEmploymentService().findById(formNo, personType);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, EmploymentController.class);
        }
        return result;
    }

    public Object update(String formNo, String personType, Employment e) {
        Object result = null;
        try {
            boolean isUpdated = UISetting.getEmploymentService().update(e);
            if (isUpdated) {
                result = UISetting.getEmploymentService().findById(formNo, personType);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, EmploymentController.class);
        }
        return result;
    }
    
    public Employment findByFormNoAndPersonType(String formNo, String personType) {
        Employment result = null;
        try {
            result = UISetting.getEmploymentService().findById(formNo, personType);
        } catch (Exception ex) {
            UIValidator.log(ex, EmploymentController.class);
        }
        return result;
    }
    
    public RepresentativeEmployment save(String formNo, String personTypeID, RepresentativeEmployment r) {
        RepresentativeEmployment result = null;
        try {
            r.setTxFormNo(formNo);
            r.setPersonType(UISetting.getPersonTypeService().findById(personTypeID));
            r.setUser(UISetting.getSystemUser());
            r.setLocation(UISetting.getStoreLocation());
            r.setStation(UISetting.getComputerName());
            RepresentativeEmployment saveObject = UISetting.getRepresentativeEmploymentService().insert(r);
            if(saveObject != null) {
                result = UISetting.getRepresentativeEmploymentService().findByFormPersonType(formNo, personTypeID);
            }
            
        } catch (Exception ex) {
            UIValidator.log(ex, EmploymentController.class);
        }
        return result;
    }
    
    public RepresentativeEmployment update(String formNo, RepresentativeEmployment r) {
        RepresentativeEmployment result = null;
        try {
            r.setUser(UISetting.getSystemUser());
            r.setLocation(UISetting.getStoreLocation());
            r.setStation(UISetting.getComputerName());
            RepresentativeEmployment saveObject = UISetting.getRepresentativeEmploymentService().update(r);
            if(saveObject != null) {
                result = UISetting.getRepresentativeEmploymentService().findByFormPersonType(formNo, r.getPersonType().getTypeID());
            }
            
        } catch (Exception ex) {
            UIValidator.log(ex, EmploymentController.class);
        }
        return result;
    }
    
    public RepresentativeEmployment findRepresentativeEmploymentByFormNoAndPersonType(String formNo, String personType) {
        RepresentativeEmployment result = null;
        try {
            result = UISetting.getRepresentativeEmploymentService().findByFormPersonType(formNo, personType);
        } catch (Exception ex) {
            UIValidator.log(ex, EmploymentController.class);
        }
        return result;
    }

}
