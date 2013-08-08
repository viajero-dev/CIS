/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.Identification;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import java.util.Date;

/**
 *
 * @author rodel
 */
public class RidersToBuyerController {

    private static RidersToBuyerController instance;

    public static RidersToBuyerController getInstance() {
        if (instance == null) {
            instance = new RidersToBuyerController();
        }
        return instance;
    }
    
    public boolean saveAgreement(String competentOfEvidence, String IdNo, String placeOfIssue, Date issueDate, String formNo) {
        Identification i = new Identification();
        i.setDateOfIssue(issueDate);
        i.setIdNo(IdNo);
        i.setPlaceOfIssue(placeOfIssue);
        i.setUser(UISetting.getSystemUser());
        i.setLocation(UISetting.getStoreLocation());
        i.setStation(UISetting.getComputerName());
        i.setTxFormNo(formNo);
//        UISetting.geti
        return true;
    }

}
