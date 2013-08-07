/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.commons.util.DateUtil;
import com.vg.scfc.financing.cis.ent.TransactionForm;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import java.util.Date;

/**
 *
 * @author rodel
 */
public class FormController {

    private static FormController instance;

    public static FormController getInstance() {
        if (instance == null) {
            instance = new FormController();
        }
        return instance;
    }
    
    public String newFormNo(String locationID, String mode, String series) {
        String location ;
        switch(locationID) {
            default:
                location = "G";
                break;
        }
        String currentDate = DateUtil.toString(DateUtil.now(), "MM-HH-yyyy");
        return location + mode + currentDate.substring(8, 10) + currentDate.substring(0, 2) + series;
    }
    
    public Object createNew(String clientNo, String formNo, Date applicationDate) {
        TransactionForm form = new TransactionForm();
        form.setTxApplicationDate(applicationDate);
        form.setClientNo(clientNo);
        form.setTxFormNo(formNo);
        /* for trail & liveupdate */
        form.setUser(UISetting.getSystemUser());
        form.setLocation(UISetting.getStoreLocation());
        form.setStation(UISetting.getComputerName());
        
        return new Object();
    }
    
    public void save(TransactionForm form) {
//        UISetting.getTransactionFormService().
    }

}
