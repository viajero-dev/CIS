/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.SourceOfIncome;
import java.math.BigDecimal;
import java.util.Date;

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
    
    public Object createNew(BigDecimal salaryCompensation, String natureOfBusiness, boolean isRegistred,
            BigDecimal businessInc, boolean isAgri, boolean isLiveStock, String harvestSched, BigDecimal productInc, BigDecimal farmInc, String otherSource, BigDecimal otherSourceInc) {
        SourceOfIncome s = new SourceOfIncome();
        s.setIncSalary(salaryCompensation.doubleValue());
        s.setIncNature(natureOfBusiness);
        s.setIncRegistered(isRegistred);
        s.setIncBusiness(businessInc.doubleValue());
        s.setIncArgriculture(isAgri);
        s.setIncLiveStock(isLiveStock);
        s.setIncHarvestDate(harvestSched);
        s.setIncAverageProd(productInc.doubleValue());
        s.setIncFarm(farmInc.doubleValue());
        s.setIncOtherSource(otherSource);
        s.setIncOther(otherSourceInc.doubleValue());
        return new Object();
    }
    
    public Object update(String formNo, BigDecimal salaryCompensation, String natureOfBusiness, boolean isRegistred,
            BigDecimal businessInc, boolean isAgri, boolean isLiveStock, String harvestSched, BigDecimal productInc, BigDecimal farmInc, String otherSource, BigDecimal otherSourceInc) {
        return new Object();
    }
}
