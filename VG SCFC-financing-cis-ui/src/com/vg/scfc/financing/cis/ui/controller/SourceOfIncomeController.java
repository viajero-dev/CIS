/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.SourceOfIncome;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author rodel
 */
public class SourceOfIncomeController {

    private static SourceOfIncomeController instance;

    public static SourceOfIncomeController getInstance() {
        if (instance == null) {
            instance = new SourceOfIncomeController();
        }
        return instance;
    }

    public Object createNew(SourceOfIncome s, String formNo, String personType, String clientNo) {
        SourceOfIncome result = null;
        try {
            s.setClientNo(clientNo);
            s.setTxForm(UISetting.getTransactionFormService().findByformNo(formNo));
            s.setPersonType(UISetting.getPersonTypeService().findById(personType));
            s.setUser(UISetting.getSystemUser());
            s.setLocation(UISetting.getStoreLocation());
            s.setStation(UISetting.getComputerName());
            result = UISetting.getSourceOfIncomeService().insert(s);
        } catch (Exception ex) {
            UIValidator.log(ex, SourceOfIncomeController.class);
        }
        return result;
    }

    public Object update(String formNo, SourceOfIncome s) {
        SourceOfIncome result = null;
        try {
            result = UISetting.getSourceOfIncomeService().update(s);
        } catch (Exception ex) {
            UIValidator.log(ex, SourceOfIncomeController.class);
        }
        return result;
    }

    public SourceOfIncome findByFormNoAndPersonType(String clientNo, String formNo, String personType) {
        SourceOfIncome result = null;
        try {
            result = UISetting.getSourceOfIncomeService().findByClientFormNoPersonType(clientNo, formNo, personType);
        } catch (Exception ex) {
            UIValidator.log(ex, SourceOfIncomeController.class);
        }
        return result;
    }

    public BigDecimal computeTotalMonthlyIncome(SourceOfIncome s) {
        if (s == null) {
            return new BigDecimal("0");
        } else {
            BigDecimal monthlyCompensation = new BigDecimal(s.getIncSalary());
            BigDecimal monthlyIncomeForBusiness = new BigDecimal(s.getIncBusiness());
            BigDecimal monthlyIncomeForFarmProd = new BigDecimal(s.getIncFarm());
            BigDecimal monthlyIncomeForOthers = new BigDecimal(s.getIncOther());
            return monthlyCompensation.add(monthlyIncomeForBusiness).add(monthlyIncomeForFarmProd).add(monthlyIncomeForOthers).round(MathContext.UNLIMITED);
        }
    }
}
