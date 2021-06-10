package com.zayan.www.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author AnYuan
 */
public class DateUtil {

    /**
     * 获取当前时间的字符串
     *
     * @return String
     */
    public static String nowDateTimeString() {
       return localDateTimeToString(LocalDateTime.now(), "HH:mm:ss");
    }

    /**
     * 获取当前时间后 year 年的时间
     *
     * @param year 单位
     * @return date
     */
    public static Date getFutureByYear(Integer year) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, year);
        return cal.getTime();
    }

    /**
     * 获取时间戳
     * @return
     */
    public static long getTimestampByLocalDateTime() {
        return LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static String localDateTimeToString(LocalDateTime localDateTime, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return localDateTime == null ? null : dateTimeFormatter.format(localDateTime);
    }

    public static String localDateTimeToString(LocalDateTime localDateTime){
        return localDateTimeToString(localDateTime,"yyyy-MM-dd HH:mm:ss");
    }
}
