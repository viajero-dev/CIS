/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Customer;
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

    public Object createNew(String lastname, String firstname, String middlename, Date birthDate, String birthPlace,
            int age, String gender, String tribe, String religion, String citizenship, String civilStatusOther, String educationalAttainment,
            String contactNo, String presentAddress, String previousAddress, String formSeries, Date applicationDate) {
        Object result = null;
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
            customer.setName(lastname + "," + firstname + " " + middlename);
            customer.setTransactionMode(transactionMode);
            customer.setUser(UISetting.getSystemUser());
            customer.setLocation(UISetting.getStoreLocation());
            customer.setStation(UISetting.getComputerName());

            /* Personal Info */
            PersonalInfo person = new PersonalInfo();
            person.setLastName(lastname);
            person.setFirstName(firstname);
            person.setMiddleName(middlename);
            person.setDateOfBirth(birthDate);
            person.setPlaceOfBirth(birthPlace);
            person.setGender(gender);
            person.setTribe(null);
            person.setReligion(null);
            person.setCitizenship(citizenship);
            person.setCivilStatus(civilStatusOther);
            person.setEducation(educationalAttainment);
            person.setContactNo(contactNo);
            person.setPersonType(UISetting.getPersonTypeService().findById("APP"));
            person.setUser(UISetting.getSystemUser());
            person.setLocation(UISetting.getStoreLocation());
            person.setStation(UISetting.getComputerName());

            boolean isSaved = UISetting.getCustomerService().insert(customer, form, person);
            if (isSaved) {
//                result = UISetting.get
            }
        } catch (Exception ex) {
            UIValidator.log(ex, PersonalInfoController.class);
        }

        return result;
    }

    public Object update(String clientNo, String lastname, String firstname, String middlename, Date birthDate, String birthPlace, int age, String gender, String tribe, String religion,
            String citizenship, String civilStatusOther, String educationalAttainment, String contactNo, String presentAddress, String previousAddress) {
        // TODO, find personal info by clientNo
        // update info
        // return object
        return new Object();
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

}
