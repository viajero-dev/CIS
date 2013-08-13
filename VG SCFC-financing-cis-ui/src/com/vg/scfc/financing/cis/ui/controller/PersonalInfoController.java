/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Customer;
import com.vg.scfc.financing.cis.ent.PersonType;
import com.vg.scfc.financing.cis.ent.PersonalInfo;
import com.vg.scfc.financing.cis.ent.Religion;
import com.vg.scfc.financing.cis.ent.TransactionForm;
import com.vg.scfc.financing.cis.ent.TransactionMode;
import com.vg.scfc.financing.cis.ent.Tribe;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rodel
 */
public class PersonalInfoController {

    private static PersonalInfoController instance;

    public static PersonalInfoController getInstance() {
        if (instance == null) {
            instance = new PersonalInfoController();
        }
        return instance;
    }

    public PersonalInfo createNew(PersonalInfo p, String formSeries, Date applicationDate) {
        PersonalInfo result = null;
        try {
            /* Form Info */
            String formNo = FormController.getInstance().newFormNo(UISetting.getStoreLocation().getId(), "2", formSeries);
            
            TransactionForm form = new TransactionForm();
            form.setTxFormNo(formNo);
            form.setTxApplicationDate(applicationDate);
            form.setUser(UISetting.getSystemUser());
            form.setStation(UISetting.getComputerName());
            form.setLocation(UISetting.getStoreLocation());

            /* Transaction Mode */
            TransactionMode transactionMode = UISetting.getTransactionModeService().findByID(2);

            /* Customer Info */
            Customer customer = new Customer();
            customer.setName(p.getLastName().toUpperCase() + "," + p.getFirstName().toUpperCase() + " " + p.getMiddleName().toUpperCase());
            customer.setTransactionMode(transactionMode);
            customer.setUser(UISetting.getSystemUser());
            customer.setLocation(UISetting.getStoreLocation());
            customer.setStation(UISetting.getComputerName());

            /* Person Type */
            PersonType personType = UISetting.getPersonTypeService().findById("APP");
            
            /* Personal Info */
            p.setPersonType(personType);
            p.setTxFormNo(formNo);
            p.setUser(UISetting.getSystemUser());
            p.setLocation(UISetting.getStoreLocation());
            p.setStation(UISetting.getComputerName());

            boolean isSaved = UISetting.getCustomerService().insert(customer, form, p);
            if (isSaved) {
                System.out.println("Find result by type: " + personType.getTypeID());
                result = UISetting.getPersonalInfoService().findByFormType(formNo, personType.getTypeID());
            }
        } catch (Exception ex) {
            UIValidator.log(ex, PersonalInfoController.class);
        }

        return result;
    }
    
    public PersonalInfo findByFormNoAndPersonType(String formNo, String personType) {
        PersonalInfo result = null;
        try {
            result = UISetting.getPersonalInfoService().findByFormType(formNo, personType);
        } catch (Exception ex) {
            UIValidator.log(ex, PersonalInfoController.class);
        }
        return result;
    }

    public PersonalInfo update(PersonalInfo p) {
        PersonalInfo result = null;
        try {
            boolean isUpdated = UISetting.getCustomerService().update(UISetting.getCustomerService().findById(p.getClientNo()), p);
            if(isUpdated) {
                result = UISetting.getPersonalInfoService().findByFormType(p.getTxFormNo(), p.getPersonType().getTypeID());
            }
        } catch (Exception ex) {
            UIValidator.log(ex, PersonalInfoController.class);
        }
        return result;
    }
    
    public List<Tribe> Tribes() {
        List<Tribe> tribes = new ArrayList<>();
        try {
            tribes = UISetting.getTribeService().getList();
        } catch (Exception ex) {
            UIValidator.log(ex, PersonalInfoController.class);
        }
        return tribes;
    }

    public List<Religion> Religions() {
        List<Religion> religions = new ArrayList<>();
        try {
            religions = UISetting.getReligionService().findAll();
        } catch (Exception ex) {
            UIValidator.log(ex, PersonalInfoController.class);
        }
        return religions;
    }
    
    public Tribe findTribeByDesc(String desc, List<Tribe> t) {
        Tribe result = null;
        for (Tribe tribe : t) {
            if(tribe.getTribeDesc().equals(desc)) {
                result = tribe;
            }
        }
        return result;
    }
    
    public Religion findReligionByDesc(String desc, List<Religion> t) {
        Religion result = null;
        for (Religion religion : t) {
            if(religion.getReligionDesc().equals(desc)) {
                result = religion;
            }
        }
        return result;
    }
    
}
