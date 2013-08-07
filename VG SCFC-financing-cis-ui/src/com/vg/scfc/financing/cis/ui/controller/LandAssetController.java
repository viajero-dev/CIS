/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Land;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodel
 */
public class LandAssetController {

    private static LandAssetController instance;

    public static LandAssetController getInstance() {
        if (instance == null) {
            instance = new LandAssetController();
        }
        return instance;
    }
    
    public boolean createNew(double agriArea, String agriLocation, BigDecimal agriValue, double comArea, String comLocation, 
            BigDecimal comValue, double resArea, String resLocation, BigDecimal resVlaue, String additionalInfo){
        /* Agricultural Land */
        if(agriValue.doubleValue() > 0) {
            Land agriLand = new Land();
            //set txno
            agriLand.setArea(agriArea);
            agriLand.setAddress(agriLocation);
            agriLand.setAmount(agriValue.doubleValue());
            //save
        }
        
        /* Commercial Land */
        if(comValue.doubleValue() > 0) {
            Land commLand = new Land();
            //set txno
            commLand.setArea(comArea);
            commLand.setAddress(comLocation);
            commLand.setAmount(comValue.doubleValue());
            //save
        }
        
        /* Residential Land */
        if(resVlaue.doubleValue() > 0) {
            Land resLand = new Land();
            //set txno
            resLand.setArea(resArea);
            resLand.setAddress(resLocation);
            resLand.setAmount(resVlaue.doubleValue());
            //save
        }
        
        return true;
    }
    
    public boolean update(String formNo, double agriArea, String agriLocation, BigDecimal agriValue, double comArea, String comLocation, 
            BigDecimal comValue, double resArea, String resLocation, BigDecimal resVlaue, String additionalInfo) {
        return true;
    }
    
    public List<Land> findAllLandAssets(String formNo) {
        return new ArrayList<>();
    }

}
