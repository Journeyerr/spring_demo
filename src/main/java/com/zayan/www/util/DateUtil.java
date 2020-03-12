package com.zayan.www.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * @desc: yyyyMMddHHmmss时间格式转化为yyyy-MM-hhmmss
     * @param:
     * @return:
     * @auther: AnYuan
     * @date: 2019-03-04
     */
    public static LocalDateTime strDataToLocalDate(String dateString){
        return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-hhmmss"));
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
