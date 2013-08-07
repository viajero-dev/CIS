/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author user
 */
public class DateUtil {

    public static Date now() {
        return Calendar.getInstance().getTime();
    }

    public static Timestamp getStartOfDay(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if (date == null) {
            date = new Date();
        }
        return Timestamp.valueOf(df.format(date) + " 00:00:00");
    }

    public static Timestamp getOtherDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return new Timestamp(calendar.getTime().getTime());
    }

    public static Timestamp getDate(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        return new Timestamp(calendar.getTime().getTime());
    }

    public static Timestamp getDate(int day, int month, int year, int hour, int minutes, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minutes);
        calendar.set(Calendar.SECOND, seconds);
        return new Timestamp(calendar.getTime().getTime());
    }

    /*
    public static Timestamp getEndOfDay(Date date) {
    if (date == null)
    date = new Date();
    
    return new Timestamp(getStartOfDay(date).getTime()
    + DateUtils.MILLIS_PER_DAY - 1);
    }
     * 
     */
    public static String toString(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    public static Date toDate(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    public static Date toDate(String date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date addTime(Date date, Date time) {
        Calendar cdate = Calendar.getInstance();
        cdate.setTime(date);

        Calendar ctime = Calendar.getInstance();
        ctime.setTime(time);

        cdate.add(Calendar.HOUR_OF_DAY, ctime.get(Calendar.HOUR_OF_DAY));
        cdate.add(Calendar.MINUTE, ctime.get(Calendar.MINUTE));
        cdate.add(Calendar.SECOND, ctime.get(Calendar.SECOND));

        return cdate.getTime();
    }

    public static Date addHours(Date date, int hours) {
        Calendar cdate = Calendar.getInstance();
        cdate.setTime(date);
        cdate.add(Calendar.HOUR_OF_DAY, hours);

        return cdate.getTime();
    }

    public static Date addMinutes(Date date, int minutes) {
        Calendar cdate = Calendar.getInstance();
        cdate.setTime(date);
        cdate.add(Calendar.MINUTE, minutes);

        return cdate.getTime();
    }

    public static Date addSeconds(Date date, int seconds) {
        Calendar cdate = Calendar.getInstance();
        cdate.setTime(date);
        cdate.add(Calendar.SECOND, seconds);

        return cdate.getTime();
    }

    public static Date toDate(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        return calendar.getTime();
    }

    public static Date getStartOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return getStartOfDay(calendar.getTime());
    }

    public static int getDateDifference(Date start, Date end, int criteria) {
        Calendar first = Calendar.getInstance();
        first.setTime(start);

        Calendar second = Calendar.getInstance();
        second.setTime(end);


        int diff = 0;
        while (first.before(second) || first.equals(second)) {
            first.add(criteria, 1);
            diff++;
        }

        return diff;
    }
    /*
    public static Date getEndOfMonth(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    calendar.set(Calendar.DAY_OF_MONTH, lastDay);
    return getEndOfDay(calendar.getTime());
    }
     * 
     */

    /*
    public static Date getEndOfYear(int year) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, 11);
    int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    calendar.set(Calendar.DAY_OF_MONTH, lastDay);
    return getEndOfDay(calendar.getTime());
    }
     * 
     */
    public static Date getStartOfYear(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return getStartOfDay(calendar.getTime());
    }

    /**returns (date + numDaysToAdd) in yyyy-MM-dd string format
     * 
     */
    public static String newStringDate(Date date, int numDaysToAdd) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, numDaysToAdd);
            return formatter.format(calendar.getTime());
        } catch (Exception e) {
            return "";
        }
    }
}
