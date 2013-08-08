/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Expenditure;
import com.vg.scfc.financing.cis.ent.ExpenditureType;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodel
 */
public class ExpenditureController {

    private static ExpenditureController instance;

    public static ExpenditureController getInstance() {
        if (instance == null) {
            instance = new ExpenditureController();
        }
        return instance;
    }

    public List<Expenditure> createNew(BigDecimal monthlySalaryDeduct, BigDecimal monthlyHouseholdBill, BigDecimal amortization, BigDecimal maintenance,
            String maintenanceDesc, BigDecimal allowance, BigDecimal education, String educationDesc, BigDecimal others, String formNo) {
        List<Expenditure> results = new ArrayList<>();
        try {
            List<Expenditure> expenditures = new ArrayList<>();
            Expenditure e;
            /* Regular Monthly Salary Deduction */
            if (monthlySalaryDeduct.doubleValue() > 0) {
                ExpenditureType eType = UISetting.getExpenditureTypeService().findById(1);
                e = new Expenditure();
                e.setExpenditureType(eType);
                e.setAdditionalInfo("");
                e.setAmount(monthlySalaryDeduct.doubleValue());
                e.setTxFormNo(formNo);
                expenditures.add(e);
            }

            /* Monthly Household Bill */
            if (monthlyHouseholdBill.doubleValue() > 0) {
                ExpenditureType eType = UISetting.getExpenditureTypeService().findById(2);
                e = new Expenditure();
                e.setExpenditureType(eType);
                e.setAdditionalInfo("");
                e.setAmount(monthlyHouseholdBill.doubleValue());
                e.setTxFormNo(formNo);
                expenditures.add(e);
            }

            /* Amortization */
            if (amortization.doubleValue() > 0) {
                ExpenditureType eType = UISetting.getExpenditureTypeService().findById(3);
                e = new Expenditure();
                e.setExpenditureType(eType);
                e.setAdditionalInfo("");
                e.setAmount(amortization.doubleValue());
                e.setTxFormNo(formNo);
                expenditures.add(e);
            }

            /* Maintenance */
            if (maintenance.doubleValue() > 0) {
                ExpenditureType eType = UISetting.getExpenditureTypeService().findById(4);
                e = new Expenditure();
                e.setExpenditureType(eType);
                e.setAdditionalInfo(maintenanceDesc);
                e.setAmount(maintenance.doubleValue());
                e.setTxFormNo(formNo);
                expenditures.add(e);
            }

            /* Living allowance */
            if (allowance.doubleValue() > 0) {
                ExpenditureType eType = UISetting.getExpenditureTypeService().findById(5);
                e = new Expenditure();
                e.setExpenditureType(eType);
                e.setAdditionalInfo("");
                e.setAmount(allowance.doubleValue());
                e.setTxFormNo(formNo);
                expenditures.add(e);
            }

            /* Education */
            if (education.doubleValue() > 0) {
                ExpenditureType eType = UISetting.getExpenditureTypeService().findById(6);
                e = new Expenditure();
                e.setExpenditureType(eType);
                e.setAdditionalInfo(educationDesc);
                e.setAmount(education.doubleValue());
                e.setTxFormNo(formNo);
                expenditures.add(e);
            }

            /* Others */
            if (others.doubleValue() > 0) {
                ExpenditureType eType = UISetting.getExpenditureTypeService().findById(7);
                e = new Expenditure();
                e.setExpenditureType(eType);
                e.setAdditionalInfo("");
                e.setAmount(others.doubleValue());
                e.setTxFormNo(formNo);
                expenditures.add(e);
            }
            
            for (Expenditure expenditure : expenditures) {
                expenditure.setUser(UISetting.getSystemUser());
                expenditure.setLocation(UISetting.getStoreLocation());
                expenditure.setStation(UISetting.getComputerName());
            }
            
            boolean isSaved = UISetting.getExpenditureService().insert(expenditures);
            if(isSaved) {
                results = UISetting.getExpenditureService().findByFormNo(formNo);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, ExpenditureController.class);
        }
        return results;
    }

    public List<Expenditure> update(String formNo, List<Expenditure> e) {
        List<Expenditure> results = new ArrayList<>();
        try {
            boolean isUpdated = UISetting.getExpenditureService().update(e);
            if(isUpdated) {
                results = UISetting.getExpenditureService().findByFormNo(formNo);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, ExpenditureController.class);
        }
        return results;
    }

    public Expenditure create(BigDecimal amount, String additionalInfo, ExpenditureType eType) {
        Expenditure e = new Expenditure();
        e.setAdditionalInfo(additionalInfo);
        e.setAmount(amount.doubleValue());
        e.setExpenditureType(eType);
        return e;
    }
    
    public BigDecimal totalExpenditures(List<Expenditure> e) {
        BigDecimal total = new BigDecimal("0");
        for (Expenditure expenditure : e) {
            total = total.add(new BigDecimal(expenditure.getAmount()));
        }
        return total.round(MathContext.UNLIMITED);
    }

}
