package cn.demo.gas.pay.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhaohg on 2017/8/6.
 */
public class DateUtil {

    public static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";


    public static String getDatePattern() {
        return DEFAULT_DATE_PATTERN;
    }

    public static String format(Date date) {
        return format(date, DEFAULT_DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        String returnValue = "";

        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }

        return (returnValue);
    }

    public static Date parse(String strDate) {
        return parse(strDate, getDatePattern());
    }

    public static Date parse(String strDate, String pattern) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.parse(strDate);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return null;
    }

    public static String getCurrentDay() {
        Date today = new Date();
        return format(today);
    }

    public static Date addSubDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, n);
        return cal.getTime();
    }

    public static String getCurrentMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return format(c.getTime());
    }


    public static Date addSubMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    public static String getCurrentYear() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR,0);
        c.set(Calendar.DAY_OF_YEAR , 1);
        return format(c.getTime());
    }

    public static Date addSubYear(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, n);
        return cal.getTime();
    }

}
