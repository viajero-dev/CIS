/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author enesgee
 */
public class NumberUtils {

    public static double round2(double value) {
        return ((double) Math.round(value * 100) / 100);
    }

    public static String doubleToString(double inputDouble) {
        NumberFormat formatter = new DecimalFormat("#,##0.00");
        return formatter.format(inputDouble);
    }
}
