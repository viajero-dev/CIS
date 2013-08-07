/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Expenditure;
import com.vg.scfc.financing.cis.ent.ExpenditureType;
import java.math.BigDecimal;
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

    public List<Object> createNew(BigDecimal monthlySalaryDeduct, BigDecimal monthlyHouseholdBill, BigDecimal amortization, BigDecimal maintenance,
            String maintenanceDesc, BigDecimal allowance, BigDecimal education, String educationDesc, BigDecimal others) {
        Expenditure e;
        /* Regular Monthly Salary Deduction */
        if (monthlySalaryDeduct.doubleValue() > 0) {
            ExpenditureType eType = null;
            e = new Expenditure();
            e.setExpenditureType(eType);
            e.setAdditionalInfo("");
            e.setAmount(monthlySalaryDeduct.doubleValue());
        }

        /* Monthly Household Bill */
        if (monthlyHouseholdBill.doubleValue() > 0) {
            ExpenditureType eType = null;
            e = new Expenditure();
            e.setExpenditureType(eType);
            e.setAdditionalInfo("");
            e.setAmount(monthlyHouseholdBill.doubleValue());
        }

        /* Amortization */
        if (amortization.doubleValue() > 0) {
            ExpenditureType eType = null;
            e = new Expenditure();
            e.setExpenditureType(eType);
            e.setAdditionalInfo("");
            e.setAmount(amortization.doubleValue());
        }

        /* Maintenance */
        if (maintenance.doubleValue() > 0) {
            ExpenditureType eType = null;
            e = new Expenditure();
            e.setExpenditureType(eType);
            e.setAdditionalInfo(maintenanceDesc);
            e.setAmount(maintenance.doubleValue());
        }

        /* Living allowance */
        if (allowance.doubleValue() > 0) {
            ExpenditureType eType = null;
            e = new Expenditure();
            e.setExpenditureType(eType);
            e.setAdditionalInfo("");
            e.setAmount(allowance.doubleValue());
        }

        /* Education */
        if (education.doubleValue() > 0) {
            ExpenditureType eType = null;
            e = new Expenditure();
            e.setExpenditureType(eType);
            e.setAdditionalInfo(educationDesc);
            e.setAmount(education.doubleValue());
        }

        /* Others */
        if (others.doubleValue() > 0) {
            ExpenditureType eType = null;
            e = new Expenditure();
            e.setExpenditureType(eType);
            e.setAdditionalInfo("");
            e.setAmount(others.doubleValue());
        }
        return new ArrayList<>();
    }

    public List<Object> update(String formNo, BigDecimal monthlySalaryDeduct, BigDecimal monthlyHouseholdBill, BigDecimal amortization, BigDecimal maintenance,
            String maintenanceDesc, BigDecimal allowance, BigDecimal education, String educationDesc, BigDecimal others) {
        // find list of expenditure by form no.
        // then, loop and update each item
        return new ArrayList<>();
    }
    
    public Expenditure create(BigDecimal amount, String additionalInfo, ExpenditureType eType) {
        Expenditure e =new Expenditure();
        e.setAdditionalInfo(additionalInfo);
        e.setAmount(amount.doubleValue());
        e.setExpenditureType(eType);
        return e;
    }

}
