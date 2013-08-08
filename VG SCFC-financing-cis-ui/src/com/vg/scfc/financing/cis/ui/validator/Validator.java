/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.validator;

import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rodel
 */
public class Validator {

    private static Validator instance;

    public static Validator getInstance() {
        if (instance == null) {
            instance = new Validator();
        }
        return instance;
    }

    public boolean hasSpecialCharacter(String input) {
        Pattern pattern = Pattern.compile("^[<>'\"/;`%~@#*!&()_^$+=-]*$");
        Matcher matcher = pattern.matcher(input.trim().replace(" ", ""));
        return (matcher.matches());
    }

    public boolean isNumeric(String input) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(input.trim().replace(" ", ""));
        return (matcher.matches());
    }

    public boolean isEmpty(String input) {
        return (input.length() <= 0);
    }
    
    public boolean isValidEmail(String input) {
        Pattern pattern = Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
        Matcher matcher = pattern.matcher(input.trim().replace(" ", ""));
        return matcher.matches();
    }

    public String newLineRemover(String input) {
        String result = "";
        StringTokenizer token = new StringTokenizer(input, "\n");
        while (token.hasMoreTokens()) {
            result += token.nextToken();
        }
        return result;
    }

    public String whiteSpaceRemover(String input) {
        String result = "";
        StringTokenizer token = new StringTokenizer(input, " ");
        while (token.hasMoreTokens()) {
            result += token.nextToken();
        }
        return result;
    }

    public String valueGeneratorByPrefixAndLength(String prefix, int actualLength, String suffix) {
        String result = "";
        String zeroes = "";
        int subtractedLength = prefix.length() + suffix.length();
        for (int i = 1; i <= actualLength - subtractedLength; i++) {
            zeroes += "0";
        }
        result += prefix + zeroes + suffix;
        return result;
    }

    public boolean isBeyondCurrentDate(Date date) {
        return date.after(new Date());
    }

    public boolean maxLengthReach(int maxLength, String input) {
        return (input.length() > maxLength);
    }
}
