package com.cn.api.app.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by aining.yang on 2017/2/3.
 */
public class DateUtil {

    public static final String FORMATTYPE1 = "yyyyMMdd";
    public static final String FORMATTYPE2 = "yyyyMMddHHmmss";

    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    public static Date addMonths(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    public static Date subDay(Date date, int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 0-amount);
        return calendar.getTime();
    }

    public static Date convert2LastSec(Date day) {
        StringBuilder dateStr = new StringBuilder(date2strExp(day, FORMATTYPE1)).append("235959");
        return str2Date(dateStr.toString(), FORMATTYPE2);
    }

    public static Date str2Date(String str, String format) {
        if (isBlank(str) || isBlank(format)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setLenient(false);//设置为严格解析
            return sdf.parse(str);
        } catch (Exception ex) {
            return null;
        }
    }

    public static String date2strExp(Date date, String format) {
        if (date == null || isBlank(format)) {
            throw new IllegalArgumentException("DateUtil_strToDate date or format is null");
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } catch (Exception ex) {
            throw new IllegalArgumentException("DateUtil_strToDate date format is error");
        }
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算俩个日期相隔天数
     *
     * @param early
     * @param late
     * @return
     */
    public static Integer daysBetween(Date early, Date late) {

        if (null == early || null == late)
            return null;

        Calendar calEarly = Calendar.getInstance();
        Calendar calLate = Calendar.getInstance();

        calEarly.setTime(early);
        calLate.setTime(late);

        /* 设置时间为0时 */
        calEarly.set(java.util.Calendar.HOUR_OF_DAY, 0);
        calEarly.set(java.util.Calendar.MINUTE, 0);
        calEarly.set(java.util.Calendar.SECOND, 0);
        calLate.set(java.util.Calendar.HOUR_OF_DAY, 0);
        calLate.set(java.util.Calendar.MINUTE, 0);
        calLate.set(java.util.Calendar.SECOND, 0);

        /* 得到俩个日期相差天数 */
        return ((int) (calLate.getTime().getTime() / 1000) - (int) (calEarly.getTime().getTime() / 1000)) / 3600 / 24;
    }

}
