/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.validator;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.slf4j.LoggerFactory;
import com.vg.scfc.financing.cis.ui.messages.ErrorMessage;

/**
 *
 * @author rodel
 */
public class UIValidator {

    public static String validate(JTextField field) {
        String fieldValue = field.getText();
        if (Validator.getInstance().isEmpty(fieldValue)) {
            JOptionPane.showMessageDialog(null, ErrorMessage.EMPTY_FIELD, ErrorMessage.ERROR_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
            field.requestFocus();
            return "";
        } else {
            return Validator.getInstance().newLineRemover(fieldValue).toUpperCase();
        }
    }
    
    public static String  isNumeric(JTextField field) {
        String fieldValue = field.getText();
        if (Validator.getInstance().isEmpty(fieldValue)) {
            JOptionPane.showMessageDialog(null, ErrorMessage.EMPTY_FIELD, ErrorMessage.ERROR_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
            field.requestFocus();
            return "0";
        } else {
            if(Validator.getInstance().isNumeric(fieldValue)) {
                return fieldValue;
            } else {
                JOptionPane.showMessageDialog(null, ErrorMessage.NON_NUMERIC, ErrorMessage.ERROR_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
                field.requestFocus();
                field.setText("");
                return "0";
            }
        }
    }
    
    public static  void promptErrorMessageOn(String errorType) {
        switch (errorType) {
            case "SAVE":
                JOptionPane.showMessageDialog(null, ErrorMessage.FAILED_TO_INSERT, ErrorMessage.ERROR_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
                break;
            case "EDIT":
                JOptionPane.showMessageDialog(null, ErrorMessage.FAILED_TO_UPDATE, ErrorMessage.ERROR_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
                break;
        }
    }
    
    public static void log(Exception e, Class c) {
        LoggerFactory.getLogger(c).error(e.toString());
    }
}
