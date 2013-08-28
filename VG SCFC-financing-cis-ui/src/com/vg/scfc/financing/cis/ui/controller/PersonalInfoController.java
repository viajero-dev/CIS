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
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public PersonalInfo save(PersonalInfo p, String formSeries, Date applicationDate, String personTypeID) {
        PersonalInfo result = null;
        try {
            if (personTypeID.equals("APP")) {
                /* Form Info */
                TransactionForm form = new TransactionForm();
                form.setFormNo(formSeries);
                form.setTxApplicationDate(applicationDate);
                form.setUser(UISetting.getSystemUser());
                form.setStation(UISetting.getComputerName());
                form.setLocation(UISetting.getStoreLocation());

                /* Transaction Mode */
                TransactionMode transactionMode = UISetting.getTransactionModeService().findByID(2);

                /* Customer Info */
                Customer customer = new Customer();
                customer.setName(p.getProperName());
                customer.setTransactionMode(transactionMode);
                customer.setUser(UISetting.getSystemUser());
                customer.setLocation(UISetting.getStoreLocation());
                customer.setStation(UISetting.getComputerName());

                /* Person Type */
                PersonType personType = UISetting.getPersonTypeService().findById(personTypeID);

                /* Personal Info */
                p.setPersonType(personType);
                p.setUser(UISetting.getSystemUser());
                p.setLocation(UISetting.getStoreLocation());
                p.setStation(UISetting.getComputerName());

                String formResult;
                if (p.getClientNo() == null) {
                    formResult = UISetting.getCustomerService().insert(customer, form, p);
                } else {
                    formResult = UISetting.getCustomerService().insert(UISetting.getCustomerService().findById(p.getClientNo()), form, p);
                }

                if (!formResult.equals("")) {
                    result = UISetting.getPersonalInfoService().findByFormType(formResult, personType.getTypeID());
                }
            } else {
                /* Person Type */
                PersonType personType = UISetting.getPersonTypeService().findById(personTypeID);

                /* Personal Info */
                p.setPersonType(personType);
                p.setTxFormNo(formSeries);
                p.setUser(UISetting.getSystemUser());
                p.setLocation(UISetting.getStoreLocation());
                p.setStation(UISetting.getComputerName());

                PersonalInfo r = UISetting.getPersonalInfoService().insert(p);
                if (r != null) {
                    result = UISetting.getPersonalInfoService().findByFormType(formSeries, personType.getTypeID());
                }
            }
        } catch (Exception ex) {
            UIValidator.log(ex, PersonalInfoController.class);
        }

        return result;
    }

    public PersonalInfo save(PersonalInfo p, String formNo, String personTypeID, String clientNo) {
        PersonalInfo result = null;
        try {
            /* Person Type */
            PersonType personType = UISetting.getPersonTypeService().findById(personTypeID);

            /* Personal Info */
            p.setClientNo(clientNo);
            p.setPersonType(personType);
            p.setTxFormNo(formNo);
            p.setUser(UISetting.getSystemUser());
            p.setLocation(UISetting.getStoreLocation());
            p.setStation(UISetting.getComputerName());

            PersonalInfo r = UISetting.getPersonalInfoService().insert(p);
            if (r != null) {
                result = UISetting.getPersonalInfoService().findByFormType(formNo, personType.getTypeID());
            }
        } catch (Exception e) {
            UIValidator.log(e, PersonalInfoController.class);
        }
        return result;
    }

    public PersonalInfo update(String formNo, String personTypeID, PersonalInfo p) {
        PersonalInfo result = null;
        try {
            p.setUser(UISetting.getSystemUser());
            p.setLocation(UISetting.getStoreLocation());
            p.setStation(UISetting.getComputerName());
            PersonalInfo r = UISetting.getPersonalInfoService().update(p);
            if (r != null) {
                result = UISetting.getPersonalInfoService().findByFormType(formNo, personTypeID);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, PersonalInfoController.class);
        }
        return result;
    }

    public PersonalInfo update(PersonalInfo p) {
        PersonalInfo result = null;
        try {
            p.setUser(UISetting.getSystemUser());
            p.setLocation(UISetting.getStoreLocation());
            p.setStation(UISetting.getComputerName());
            boolean isUpdated = UISetting.getCustomerService().update(UISetting.getCustomerService().findById(p.getClientNo()), p);
            if (isUpdated) {
                result = UISetting.getPersonalInfoService().findByFormType(p.getTxFormNo(), p.getPersonType().getTypeID());
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
            if (tribe.getTribeDesc().equals(desc)) {
                result = tribe;
            }
        }
        return result;
    }

    public Religion findReligionByDesc(String desc, List<Religion> t) {
        Religion result = null;
        for (Religion religion : t) {
            if (religion.getReligionDesc().equals(desc)) {
                result = religion;
            }
        }
        return result;
    }

    public List<PersonalInfo> findCoMakersByFormNo(String formNo) {
        List<PersonalInfo> results = new ArrayList<>();
        try {
            PersonalInfo cm1 = PersonalInfoController.getInstance().findByFormNoAndPersonType(formNo, "CM1");
            PersonalInfo cm2 = PersonalInfoController.getInstance().findByFormNoAndPersonType(formNo, "CM2");
            if (cm1 != null) {
                results.add(cm1);
            }
            if (cm2 != null) {
                results.add(cm2);
            }
        } catch (Exception e) {
            UIValidator.log(e, PersonalInfoController.class);
        }
        return results;
    }

    public List<PersonalInfo> findBySearchCriteria(String criteria) {
        List<PersonalInfo> results = new ArrayList<>();
        try {
            results = UISetting.getPersonalInfoService().findBySearchString(criteria);
        } catch (Exception ex) {
            UIValidator.log(ex, PersonalInfoController.class);
        }
        return results;
    }

    public List<PersonalInfo> findBySearchCriteriaWithLimit(String criteria, int limit) {
        List<PersonalInfo> results = new ArrayList<>();
        try {
            List<PersonalInfo> tempResults = UISetting.getPersonalInfoService().findBySearchString(criteria);
            for (int i = 1; i <= limit; i++) {
                if (tempResults.size() >= limit) {
                    results.add(tempResults.get(i));
                } else {
                    results.addAll(tempResults);
                }
            }
        } catch (Exception ex) {
            UIValidator.log(ex, PersonalInfoController.class);
        }
        return results;
    }

}
