/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.validator;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ui.messages.ErrorMessage;
import com.vg.scfc.financing.cis.ui.messages.OtherMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.slf4j.LoggerFactory;

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

    public static String isNumeric(JTextField field) {
        String fieldValue = field.getText();
        if (Validator.getInstance().isEmpty(fieldValue)) {
            JOptionPane.showMessageDialog(null, ErrorMessage.EMPTY_FIELD, ErrorMessage.ERROR_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
            field.requestFocus();
            return "0";
        } else {
            if (Validator.getInstance().isNumeric(fieldValue)) {
                return fieldValue;
            } else {
                JOptionPane.showMessageDialog(null, ErrorMessage.NON_NUMERIC, ErrorMessage.ERROR_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
                field.requestFocus();
                field.setText("");
                return "0";
            }
        }
    }

    public static String isValidEmail(JTextField field) {
        String fieldValue = field.getText();
        if (Validator.getInstance().isValidEmail(fieldValue)) {
            return fieldValue;
        } else {
            JOptionPane.showMessageDialog(null, ErrorMessage.INVALID_EMAIL, ErrorMessage.ERROR_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
            return "";
        }
    }

    public static void promptErrorMessageOn(String errorType) {
        switch (errorType) {
            case "SAVE":
                JOptionPane.showMessageDialog(null, ErrorMessage.FAILED_TO_INSERT, ErrorMessage.ERROR_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
                break;
            case "EDIT":
                JOptionPane.showMessageDialog(null, ErrorMessage.FAILED_TO_UPDATE, ErrorMessage.ERROR_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
                break;
        }
    }

    public static void promptSucessMessageFor(String successType) {
        switch (successType) {
            case "SAVE":
                JOptionPane.showMessageDialog(null, OtherMessage.SUCCESSFUL_INSERT, ErrorMessage.ERROR_MESSAGE_TITLE, JOptionPane.INFORMATION_MESSAGE);
                break;
            case "EDIT":
                JOptionPane.showMessageDialog(null, OtherMessage.SUCCESSFUL_UPDATE, ErrorMessage.ERROR_MESSAGE_TITLE, JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    public static void log(Exception e, Class c) {
        LoggerFactory.getLogger(c).error(StringUtils.formatException(e));
    }

    public static String MoneyCommaRemover(String input) {
        return Validator.getInstance().commaRemover(input);
    }
}
