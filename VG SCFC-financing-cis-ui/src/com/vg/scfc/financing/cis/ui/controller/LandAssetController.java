/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Asset;
import com.vg.scfc.financing.cis.ent.Land;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public List<Land> createNew(double agriArea, String agriLocation, BigDecimal agriValue, double comArea, String comLocation,
            BigDecimal comValue, double resArea, String resLocation, BigDecimal resVlaue, String additionalInfo, String formNo) {
        List<Land> results = new ArrayList<>();
        try {
            List<Land> lands = new ArrayList<>();

            /* Agricultural Land */
            if (agriValue.doubleValue() > 0) {
                Land agriLand = new Land();
                agriLand.setArea(agriArea);
                agriLand.setAddress(agriLocation);
                agriLand.setAmount(agriValue.doubleValue());
                agriLand.setAdditionalInfo("");
                agriLand.setLandType(UISetting.getLandTypeService().findByID(1));
                lands.add(agriLand);
            }

            /* Commercial Land */
            if (comValue.doubleValue() > 0) {
                Land commLand = new Land();
                commLand.setArea(comArea);
                commLand.setAddress(comLocation);
                commLand.setAmount(comValue.doubleValue());
                commLand.setAdditionalInfo("");
                commLand.setLandType(UISetting.getLandTypeService().findByID(2));
                lands.add(commLand);
            }

            /* Residential Land */
            if (resVlaue.doubleValue() > 0) {
                Land resLand = new Land();
                resLand.setArea(resArea);
                resLand.setAddress(resLocation);
                resLand.setAmount(resVlaue.doubleValue());
                resLand.setAdditionalInfo(additionalInfo);
                resLand.setLandType(UISetting.getLandTypeService().findByID(3));
                lands.add(resLand);
            }

            boolean encounteredError = false;
            for (Land land : lands) {
                land.setUser(UISetting.getSystemUser());
                land.setLocation(UISetting.getStoreLocation());
                land.setStation(UISetting.getComputerName());

                Land l = UISetting.getLandService().insert(formNo, land);
                if (l != null) {
                    results.add(l);
                } else {
                    encounteredError = true;
                    break;
                }
            }

            if (encounteredError) {
                throw new Exception();
            }
        } catch (Exception e) {
            UIValidator.log(e, LandAssetController.class);
        }

        return results;
    }

    public List<Land> update(List<Land> l) {
        List<Land> results = new ArrayList<>();
        try {
            boolean encounteredError = false;
            for (Land land : l) {
                Land result = UISetting.getLandService().update(land);
                if (result != null) {
                    results.add(result);
                } else {
                    encounteredError = true;
                    break;
                }
            }
            if (encounteredError) {
                throw new Exception();
            }
        } catch (Exception ex) {
            UIValidator.log(ex, LandAssetController.class);
        }
        return results;
    }

    public List<Land> findAllLandAssets(String formNo) {
        List<Land> results = new ArrayList<>();
        try {
            UISetting.getLandService().findByAsset(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, LandAssetController.class);
        }
        return results;
    }

}
