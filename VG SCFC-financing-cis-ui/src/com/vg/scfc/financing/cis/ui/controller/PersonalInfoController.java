/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.PersonalInfo;
import com.vg.scfc.financing.cis.ent.Religion;
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

    public Object createNew(String lastname, String firstname, String middlename, Date birthDate, String birthPlace, int age, String gender, String tribe, String religion,
            String citizenship, String civilStatusOther, String educationalAttainment, String contactNo, String presentAddress, String previousAddress) {

        PersonalInfo p = new PersonalInfo();
        p.setLastName(lastname);
        p.setFirstName(firstname);
        p.setMiddleName(middlename);
        p.setDateOfBirth(birthDate);
        p.setPlaceOfBirth(birthPlace);
        p.setGender(gender);
        p.setTribe(null);
        p.setReligion(null);
        p.setCitizenship(citizenship);
        p.setCivilStatus(civilStatusOther);
        p.setEducation(educationalAttainment);
        p.setContactNo(contactNo);

        return new Object();
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
