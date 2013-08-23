/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ent.LiveUpdatePicture;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vg.img.classes.VgImageIcon;

/**
 *
 * @author rodel
 */
public class PhotoController {

    private static PhotoController instance;

    public static PhotoController getInstance() {
        if (instance == null) {
            instance = new PhotoController();
        }
        return instance;
    }

    public void save(LiveUpdatePicture l) {
        try {
            UISetting.getLiveUpdatePictureService().insertOrUpdatePicture(l);
        } catch (Exception ex) {
            UIValidator.log(ex, PhotoController.class);
        }
    }
    
    public VgImageIcon findByName(String name) {
        VgImageIcon icon = null;
        try {
            icon = UISetting.getImageService().findByName(name);
        } catch (RemoteException ex) {
            UIValidator.log(ex, PhotoController.class);
        }
        return icon;
    }

}
