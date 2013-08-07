/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author user
 */
public class StringUtils {

    public static int toInt36(String s) {
        int radix = 36;
        int len = s.length();
        int sum = 0;
        char c = '0';
        int lastCharIdx = len - 1;
        int i, j;
        for (i = lastCharIdx, j = 0; i >= 0; i--, j++) {
            c = s.charAt(i);
            if (c == 0) {
                continue;
            } else {
                sum += Integer.parseInt(Character.toString(c), radix) * Math.pow(radix, j);
            }
        }
        return sum;
    }

    public static String increment36(String s) {
        int len = s.length();
        int newIntVal = toInt36(s) + 1;

        String s36 = Integer.toString(newIntVal, 36).toUpperCase();
        int len36 = s36.length();

        String s2Return = "";
        int diffLen = len - len36;
        for (int i = 0; i < diffLen; i++) {
            s2Return += "0";
        }
        s2Return += s36;
        return s2Return;
    }

    public static String reverse(String s) {
        String revS = null;
        int len = s.length();
        char[] chA = new char[len];
        for (int i = 0; i < len; i++) {
            chA[len - i - 1] = s.charAt(i);
        }
        return revS = String.valueOf(chA);
    }

    // stringValue contains A-Z only
    // if Z, return ZA
    // if ZA, return ZB
    // if ZZZ, return ZZZA
    public static String alphaIncrement(String stringValue) {
        int len = stringValue.length();
        long newIntValue = Long.parseLong(stringValue, 36) + 1;
        String newStringValue = Long.toString(newIntValue, 36).toUpperCase();
        int newLen = newStringValue.length();
        if (newLen > len) {
            return stringValue + "A";
        } else {
            return newStringValue;
        }
    }

    public static String generateCode01(String code) {
        int len = code.length();

        String nonDigitPart = "";
        String digitPart = "";
        int i;
        char ch;
        // separate letters only from digits only
        for (i = 0; i < len; i++) {
            ch = code.charAt(i);
            if (Character.isDigit(ch)) {
                digitPart += ch;
            } else {
                nonDigitPart += ch;
            }
        }

        /*
        boolean isSameLen = true;
        long codeNum = Long.parseLong(digitPart);
        int lenCodeNum = digitPart.length();
        
        long newCodeNum = Long.parseLong(digitPart) + 1;            
        String newCodeString = Long.toString(newCodeNum);            
        int lenNewCodeNum = newCodeString.length();
        
        if (lenNewCodeNum > lenCodeNum) {
        isSameLen = false;
        } else {
        //newCodeString
        }
         * 
         */
        String newCodeString = Long.toString(Long.parseLong(digitPart) + 1);
        int lenNewCodeNum = newCodeString.length();

        int len2 = newCodeString.length();

        String codeToReturn = "";
        if (nonDigitPart.length() > 0) {
            codeToReturn = nonDigitPart;
            len2 += nonDigitPart.length();
        }

        int diffLen = len - len2;
        for (i = 0; i < diffLen; i++) {
            codeToReturn += "0";
        }
        codeToReturn += newCodeString;
        return codeToReturn;
    }

    public static boolean isVowel(char c) {
        char capital = Character.toUpperCase(c);
        return (capital == 'A' || capital == 'E' || capital == 'I'
                || capital == 'O' || capital == 'U');
    }

    public static String padLeadingZeroes(int num, int numDigits) {
        assert numDigits > 0 : "Invalid number of digits";
        char[] zeros = new char[numDigits];
        Arrays.fill(zeros, '0');
        DecimalFormat df = new DecimalFormat(String.valueOf(zeros));
        return df.format(num);
    }

    public static String padLeadingZeroes(String strNum, int numDigits) {
        assert numDigits > 0 : "Invalid number of digits";
        int num = Integer.parseInt(strNum);
        char[] zeros = new char[numDigits];
        Arrays.fill(zeros, '0');
        DecimalFormat df = new DecimalFormat(String.valueOf(zeros));
        return df.format(num);
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String generateNextSeriesNo(String lastSeriesNo) {
        String tempString = lastSeriesNo;
        String LeftString = "";
        String RightString = "";
        int tempInt = 0;
        String checkValue = "";

        try {
            tempInt = Integer.parseInt(tempString);
            LeftString = "";
            RightString = tempString;
        } catch (Exception ex) {
            char[] newchar = tempString.toCharArray();
            for (int x = 0; x < newchar.length; x++) {
                try {
                    tempInt = Integer.parseInt("" + newchar[x]);
                    RightString = RightString + ("" + newchar[x]);
                } catch (Exception e) {
                    LeftString = LeftString + ("" + newchar[x]);
                }
            }
        }
        System.out.println("Left : " + LeftString);
        System.out.println("Right : " + RightString);

        checkValue = "";
        for (int xx = 0; xx < RightString.length(); xx++) {
            checkValue = checkValue + "9";
        }
//        System.out.println("Check Value : " + checkValue );

        if (RightString.equals(checkValue) != true) {
            tempInt = Integer.parseInt(RightString);
            tempInt++;

            tempString = Integer.toString(tempInt);
            checkValue = "";
            for (int xx1 = 0; xx1 < (RightString.length() - tempString.length()); xx1++) {
                checkValue = checkValue + "0";
            }
            RightString = checkValue + tempString;
        } else if (RightString.equals("")) {
            RightString = "";
            LeftString = "";
        } else {
            if (LeftString.isEmpty()) {
                LeftString = "A";
                checkValue = "";
                for (int xx1 = 1; xx1 < RightString.length(); xx1++) {
                    checkValue = checkValue + "0";
                }
                RightString = checkValue;
            } else {
                tempString = "" + LeftString.charAt(LeftString.length() - 1);
                if (tempString.equals("Z")) {
                    LeftString = LeftString + "A";
                    checkValue = "";
                    for (int xx1 = 1; xx1 < RightString.length(); xx1++) {
                        checkValue = checkValue + "0";
                    }
                    RightString = checkValue;
                } else {
                    tempInt = (int) LeftString.charAt(LeftString.length() - 1);
                    tempInt++;
                    char[] chars = LeftString.toCharArray();
                    chars[chars.length - 1] = (char) tempInt;
                    LeftString = "";
                    for (int xx2 = 0; xx2 < chars.length; xx2++) {
                        LeftString = LeftString + chars[xx2];
                    }
                    checkValue = "";
                    for (int xx3 = 0; xx3 < RightString.length(); xx3++) {
                        checkValue = checkValue + "0";
                    }
                    RightString = checkValue;
                }
            }
        }
        return LeftString + RightString;
    }

    /** Returns the String representation of value (a double) rounded to 2 decimal places
     ** works correctly for 9999999999999.99 (13 digits before decimal point)   
     **/
    public static String round2(double value) {
        return new DecimalFormat("#,###.00").format((double) Math.round(value * 100) / 100);
    }

    /**
     * 
     * @param sVal is in format #,###.00
     * @return double equivalent of sVal
     */
    public static double parseDouble(String sVal) {
        return Double.parseDouble(sVal.replaceAll(",", ""));
    }

    public static String generateNextTransNo(String lastTransNo) {
        String newTransNo = "";
        String zeroPrefix = "";
        String locationID = lastTransNo.substring(0, 4);
        String transNoToBeExecuted = lastTransNo.substring(4, lastTransNo.length());

        newTransNo = Long.toString(Long.parseLong(transNoToBeExecuted, 36) + 1, 36);

        // pad with zeros (if neccessary)
        for (int i = 1; i <= transNoToBeExecuted.length() - newTransNo.length(); i++) {
            zeroPrefix += "0";
        }
        return (locationID + zeroPrefix + newTransNo).toUpperCase();
    }

    public static String generateNextTransNoBySystem(String lastTransNo) {
        lastTransNo = lastTransNo.trim();
        String newTransNo = "";
        String zeroPrefix = "";
        String locationID = lastTransNo.substring(0, 4);
        String systemName = lastTransNo.substring(4, 7);
        String transNoToBeExecuted = lastTransNo.substring(7, lastTransNo.length());

        long x = Long.parseLong(transNoToBeExecuted, 36) + 1;

//        newTransNo = Integer.toString(Integer.parseInt(transNoToBeExecuted, 36)+1 ,36);
        newTransNo = Long.toString(x, 36);

        System.out.println("NewTrasno: " + newTransNo.length());
        System.out.println("TransNoTB: " + transNoToBeExecuted.length());

        // pad with zeros (if neccessary)
        for (int i = 1; i <= transNoToBeExecuted.length() - newTransNo.length(); i++) {
            zeroPrefix += "0";
        }
        return (locationID + systemName + zeroPrefix + newTransNo).toUpperCase();
    }

    public static boolean gt(String callerTransNo, String transNo) {
        return Integer.parseInt(callerTransNo, 36) > Integer.parseInt(transNo, 36);
    }

    public static boolean lt(String callerTransNo, String transNo) {
        return Integer.parseInt(callerTransNo, 36) < Integer.parseInt(transNo, 36);
    }

    public static String toSQLCommand(String action, String detail) {
        detail = detail.replace("'", "");
        String f1 = "";
        String f2 = "";
        String result = "";
        List<String> ls = new ArrayList<>();
        List<String> ls1 = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(detail, "$");
        while (st.hasMoreTokens()) {
            ls.add(st.nextToken());
        }

        if (action.equalsIgnoreCase("INSERT")) {
            for (String rec : ls) {
                ls1.clear();
                st = new StringTokenizer(rec, "~");
                while (st.hasMoreTokens()) {
                    ls1.add(st.nextToken());
                }
                switch (ls1.size()) {
                    case 4: // prim key
                        if (f1.isEmpty()) {
                            f1 = ls1.get(1).toString();
                        } else {
                            f1 += "," + ls1.get(1).toString();
                        }

                        result = ls1.get(2).toString();
                        if (ls1.get(3).toString().trim().equals("S") || ls1.get(3).equals("D")) {
                            result = "'" + result + "'";
                        }

                        if (f2.isEmpty()) {
                            f2 = result;
                        } else {
                            f2 += "," + result;
                        }
                        break;
                    case 3: // ordinary column
                        if (ls1.get(0).equalsIgnoreCase("#")) {
                            if (f1.isEmpty()) {
                                f1 = ls1.get(1).toString();
                            } else {
                                f1 += "," + ls1.get(1).toString();
                            }

                            result = "";
                            if (ls1.get(2).toString().trim().equals("S") || ls1.get(2).equals("D")) {
                                result = "'" + result + "'";
                            }

                            if (f2.isEmpty()) {
                                f2 = result;
                            } else {
                                f2 += "," + result;
                            }
                        } else {
                            if (f1.isEmpty()) {
                                f1 = ls1.get(0).toString();
                            } else {
                                f1 += "," + ls1.get(0).toString();
                            }

                            result = ls1.get(1).toString();
                            if (ls1.get(2).toString().trim().equals("S") || ls1.get(2).equals("D")) {
                                result = "'" + result + "'";
                            }

                            if (f2.isEmpty()) {
                                f2 = result;
                            } else {
                                f2 += "," + result;
                            }
                        }
                        break;

                    case 2:
                        if (f1.isEmpty()) {
                            f1 = ls1.get(0).toString();
                        } else {
                            f1 += "," + ls1.get(0).toString();
                        }

                        result = "";
                        if (ls1.get(1).toString().trim().equals("S") || ls1.get(1).equals("D")) {
                            result = "'" + result + "'";
                        }

                        if (f2.isEmpty()) {
                            f2 = result;
                        } else {
                            f2 += "," + result;
                        }
                        break;
                }
            }

            result = "INSERT INTO " + ls.get(0).toString() + "(" + f1 + ") VALUES(" + f2 + ")";

        } else if (action.equalsIgnoreCase("UPDATE")) {
            for (String rec : ls) {
                ls1.clear();
                st = new StringTokenizer(rec, "~");
                while (st.hasMoreTokens()) {
                    ls1.add(st.nextToken());
                }
                switch (ls1.size()) {
                    case 4:
                        result = ls1.get(2).toString().trim();
                        if (ls1.get(3).equals("S") || ls1.get(3).equals("D")) {
                            result = "'" + result + "'";
                        }


                        if (f1.trim().isEmpty()) {
                            f1 += ls1.get(1).toString() + "=" + result;
                        } else {
                            f1 += " AND " + ls1.get(1).toString() + "=" + result;
                        }
                        break;
                    case 3:
                        if (ls1.get(0).equalsIgnoreCase("#")) {
                            result = "";
                            if (ls1.get(2).equals("S") || ls1.get(2).equals("D")) {
                                result = "'" + result + "'";
                            }

                            if (f2.trim().isEmpty()) {
                                f2 += "SET " + ls1.get(1).toString() + "=" + result;
                            } else {
                                f2 += "," + ls1.get(1).toString() + "=" + result;
                            }
                        } else {
                            result = ls1.get(1).toString().trim();
                            if (ls1.get(2).equals("S") || ls1.get(2).equals("D")) {
                                result = "'" + result + "'";
                            }

                            if (f2.trim().isEmpty()) {
                                f2 += "SET " + ls1.get(0).toString() + "=" + result;
                            } else {
                                f2 += "," + ls1.get(0).toString() + "=" + result;
                            }
                        }
                        break;
                    case 2:
                        result = "";
                        if (ls1.get(1).equals("S") || ls1.get(1).equals("D")) {
                            result = "'" + result + "'";
                        }

                        if (f2.trim().isEmpty()) {
                            f2 += "SET " + ls1.get(0).toString() + "=" + result;
                        } else {
                            f2 += "," + ls1.get(0).toString() + "=" + result;
                        }
                        break;
                }
            }

            result = "UPDATE " + ls.get(0).toString() + " " + f2 + " WHERE " + f1;
        } else if (action.equalsIgnoreCase("DELETE")) {
            result = "DELETE FROM " + ls.get(0).toString() + " ";
            for (String rec : ls) {
                ls1.clear();
                st = new StringTokenizer(rec, "~");
                if (st.countTokens() == 4) {
                    while (st.hasMoreTokens()) {
                        ls1.add(st.nextToken());
                    }

                    f2 = ls1.get(2).toString();
                    if (ls1.get(3).equals("S") || ls1.get(3).equals("D")) {
                        f2 = "'" + f2 + "'";
                    }


                    if (f1.trim().isEmpty()) {
                        f1 += ls1.get(1).toString() + "=" + f2;
                    } else {
                        f1 += " AND " + ls1.get(1).toString() + "=" + f2;
                    }
                }
            }
            result += " WHERE " + f1;
        }
        return result;

    }

    public static String formatException(Exception e) {
        String st = "";
        int size = e.getStackTrace().length;
        for (int i = 0; i < size; i++) {
            st += "\n\t" + e.getStackTrace()[i];
        }
        st = e + st + "\n";
        return st;
    }
}
