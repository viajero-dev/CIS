/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.controller;

import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author rodel
 */
public class ReportController {

    private static ReportController instance;

    public static ReportController getInstance() {
        if (instance == null) {
            instance = new ReportController();
        }
        return instance;
    }

    public JasperPrint print(String formNo, int option, String personType) {
        JasperPrint result = null;
        try {
            switch (option) {
                case 1:
                    result = UISetting.getPrintReportService().printApplicantFront(formNo);
                    break;
                case 2:
                    result = UISetting.getPrintReportService().printApplicantBack(formNo);
                    break;
                case 3:
                    result = UISetting.getPrintReportService().printCoMaker(formNo, personType);
                    break;
                case 4:
                    result = UISetting.getPrintReportService().printCoMaker(formNo, personType);
                    break;
            }
        } catch (Exception e) {
            UIValidator.log(e, ReportController.class);
        }
        return result;
    }

    public JasperPrint print(String formNo) {
        JasperPrint result = null;
        try {
            result = UISetting.getPrintReportService().printInstitution(formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, ReportController.class);
        }
        return result;
    }

    public JasperPrint printPurchaseOrder(String formNo) {
        JasperPrint result = null;
        try {
            result = UISetting.getPrintReportService().printPurchaseOrder(UISetting.getStoreLocation(), formNo);
        } catch (Exception ex) {
            UIValidator.log(ex, ReportController.class);
        }
        return result;
    }

}
