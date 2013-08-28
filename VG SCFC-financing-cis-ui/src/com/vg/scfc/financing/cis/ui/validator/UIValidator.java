/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.validator;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.ui.messages.ErrorMessage;
import com.vg.scfc.financing.cis.ui.messages.OtherMessage;
import java.awt.Component;
import java.awt.Container;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.utils.FadingUtils;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rodel
 */
public class UIValidator {

    public static String validate(JTextField field) {
        String fieldValue = field.getText();
        if (Validator.getInstance().isEmpty(fieldValue)) {
//            JOptionPane.showMessageDialog(null, ErrorMessage.EMPTY_FIELD, ErrorMessage.ERROR_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
//            field.requestFocus();
            return "";
        } else {
            return Validator.getInstance().newLineRemover(fieldValue).toUpperCase();
        }
    }

    public static String isNumeric(JTextField field) {
        BalloonTip tip = null;
        String fieldValue = field.getText();
        if (Validator.getInstance().isEmpty(fieldValue)) {
            return "0";
        } else {
            if (Validator.getInstance().isNumeric(fieldValue)) {
                return fieldValue;
            } else {
                tip = new BalloonTip(field, ErrorMessage.NON_NUMERIC);
                FadingUtils.fadeOutBalloon(tip, null, 5000, 24);
//                JOptionPane.showMessageDialog(null, ErrorMessage.NON_NUMERIC, ErrorMessage.ERROR_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
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
            default:
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
            default:
                break;
        }
    }

    public static void promptFormValidationMessage() {
        JOptionPane.showMessageDialog(null, ErrorMessage.REQUIRED_FIELDS, ErrorMessage.ERROR_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
    }

    public static void log(Exception e, Class c) {
        LoggerFactory.getLogger(c).error(StringUtils.formatException(e));
    }

    public static String MoneyCommaRemover(String input) {
        return Validator.getInstance().commaRemover(input);
    }

    public static int getSelectedIndex(JComboBox comboBox, String item) {
        int selectedIndex = 0;
        int itemCount = comboBox.getItemCount();
        for (int i = 0; i <= itemCount; i++) {
            if (((String) comboBox.getItemAt(i)).equals(item)) {
                selectedIndex = i;
            }
        }
        return selectedIndex;
    }

    public static String generateFormSeries(String input) {
        String zeroes = "";
        for (int i = 1; i <= 5 - input.length(); i++) {
            zeroes += "0";
        }
        return zeroes + input;
    }

    public static boolean validate(List<JTextField> fields) {
        boolean isValid = true;
        for (JTextField field : fields) {
            if (field.getText().equals("")) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public static void manageTab(List<JPanel> panels, String tabName) {
        for (JPanel panel : panels) {
            if (panel.getName().equals(tabName)) {
                panel.setEnabled(true);
            } else {
                for (Component c : panel.getComponents()) {
                    c.setEnabled(false);
                    if (c instanceof Container) {
                        for (Component component : ((Container) c).getComponents()) {
                            component.setEnabled(false);
                        }
                    }
                }
            }
        }
    }

    public static void enableTabs(List<JPanel> panels) {
        for (JPanel panel : panels) {
            for (Component c : panel.getComponents()) {
                c.setEnabled(true);
                if (c instanceof Container) {
                    for (Component component : ((Container) c).getComponents()) {
                        component.setEnabled(true);
                    }
                }
            }
        }
    }

}
