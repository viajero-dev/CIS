/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Asset;
import com.vg.scfc.financing.cis.ent.Land;
import com.vg.scfc.financing.cis.ent.LandType;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
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

    public List<Land> createNew(List<Land> lands, String formNo) {
        List<Land> results = new ArrayList<>();
        try {
            Asset asset = UISetting.getAssetService().findByForm(formNo);
            if(asset == null) {
                Asset a = new Asset();
                a.setTxFormNo(formNo);
                a.setUser(UISetting.getSystemUser());
                a.setLocation(UISetting.getStoreLocation());
                a.setStation(UISetting.getComputerName());
                asset = UISetting.getAssetService().insert(a);
            }
            
            boolean encounteredError = false;
            for (Land land : lands) {
                land.setAsset(asset);
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
                land.setUser(UISetting.getSystemUser());
                land.setLocation(UISetting.getStoreLocation());
                land.setStation(UISetting.getComputerName());
                
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

    public LandType findLandTypeByID(int id) {
        LandType result = null;
        try {
            result = UISetting.getLandTypeService().findByID(id);
        } catch (Exception ex) {
            UIValidator.log(ex, LandAssetController.class);
        }
        return result;
    }

}
