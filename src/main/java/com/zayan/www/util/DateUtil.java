package com.zayan.www.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author AnYuan
 */
public class DateUtil {

    /**
     * yyyyMMddHHmmss时间格式转化为yyyy-MM-hhmmss
     * @param: dateString
     * @return: LocalDateTime
     */
    public static LocalDateTime strDataToLocalDate(String dateString){
        return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-hhmmss"));
    }

    /**
     * 获取当前时间的字符串
     * @return String
     */
    public static String localDateTimeStr() {
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(nowDate);
    }

    /**
     * 获取当前时间后 year 年的时间
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
}
