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

    public List<Expenditure> createNew(List<Expenditure> expenditures, String formNo) {
        List<Expenditure> results = new ArrayList<>();
        try {
            for (Expenditure expenditure : expenditures) {
                expenditure.setUser(UISetting.getSystemUser());
                expenditure.setLocation(UISetting.getStoreLocation());
                expenditure.setStation(UISetting.getComputerName());
            }
            boolean isSaved = UISetting.getExpenditureService().insert(expenditures);
            if (isSaved) {
                results = UISetting.getExpenditureService().findByFormNo(formNo);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, ExpenditureController.class);
        }
        return results;
    }

    public List<Expenditure> update(String formNo, List<Expenditure> expenditures) {
        List<Expenditure> results = new ArrayList<>();
        try {
            for (Expenditure expenditure : expenditures) {
                expenditure.setUser(UISetting.getSystemUser());
                expenditure.setLocation(UISetting.getStoreLocation());
                expenditure.setStation(UISetting.getComputerName());
            }
            boolean isUpdated = UISetting.getExpenditureService().update(expenditures);
            if (isUpdated) {
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

    public ExpenditureType findByID(int id) {
        ExpenditureType result = null;
        try {
            result = UISetting.getExpenditureTypeService().findById(id);
        } catch (Exception ex) {
            UIValidator.log(ex, ExpenditureController.class);
        }
        return result;
    }

    public List<Expenditure> findByFormNo(String formNo) {
        List<Expenditure> results = new ArrayList<>();
        try {
            results = UISetting.getExpenditureService().findByFormNo(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, ExpenditureController.class);
        }
        return results;
    }

}
