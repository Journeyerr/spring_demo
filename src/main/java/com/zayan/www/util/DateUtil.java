package com.zayan.www.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static final int STATISTIC_BEGIN_HOUR = 4;
    /**
     * 凌晨0点
     */
    public static final String WEE_HOURS = "00:00:00";
    /**
     * 午夜
     */
    public static final String MIDNIGHT = "23:59:59";

    /**
     * 工作日起始时间（0-4点取昨天4:00，4点后取今天4:00）
     *
     * @return
     */
    public static Date workdayStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        calendar.set(Calendar.HOUR_OF_DAY, 4);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        if (0 <= hour && STATISTIC_BEGIN_HOUR >= hour) {
            calendar.add(Calendar.DATE, -1);
            return calendar.getTime();
        } else {
            return calendar.getTime();
        }
    }

    /**
     * 工作日结束时间（0-4点取今天4:00，4点后取明天4:00）
     *
     * @return
     */
    public static Date workdayEndTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        calendar.set(Calendar.HOUR_OF_DAY, 4);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        if (0 <= hour && STATISTIC_BEGIN_HOUR >= hour) {
            return calendar.getTime();
        } else {
            calendar.add(Calendar.DATE, 1);
            return calendar.getTime();
        }
    }

    /**
     * @desc 获取当前工作日，0-4点算昨天
     * @params []
     * @returnDesc
     * @author 古力 2018/10/23 下午7:38
     */
    public static Date workdayNowDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (0 <= hour && STATISTIC_BEGIN_HOUR >= hour) {
            calendar.add(Calendar.HOUR_OF_DAY, -20);
            return calendar.getTime();
        } else {
            return calendar.getTime();
        }
    }

    /**
     * 前一周起始时间（当前日期往前推7天的0:00）
     *
     * @return
     */
    public static Date workweekStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DATE, -7);
        return calendar.getTime();
    }

    /**
     * 前一周结束时间（0-4点取昨天4:00，4点后取今天4:00）
     *
     * @return
     */
    public static Date workweekEndTime() {
        return workdayStartTime();
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getNowDate() {
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(nowDate);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getNowTime() {
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(nowDate);
    }

    /**
     * Date类型转LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    public static String localDateTime2String(LocalDateTime localDateTime, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);

        return localDateTime == null ? null : dateTimeFormatter.format(localDateTime);
    }

    /**
     * 将HH:mm格式的时间字符串转换为当天时间
     *
     * @param timeStr
     * @return
     */
    public static Date getDateTimeByTimeStr(String timeStr) throws ParseException {
        Calendar result = Calendar.getInstance();
        result.setTime(new Date());
        Date date = new SimpleDateFormat("HH:mm").parse(timeStr);
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        result.set(result.get(Calendar.YEAR)
                , result.get(Calendar.MONTH)
                , result.get(Calendar.DATE)
                , time.get(Calendar.HOUR_OF_DAY)
                , time.get(Calendar.MINUTE)
                , 0);
        if ("24:00".equals(timeStr)) {
            result.add(Calendar.DATE,1);
        }
        return result.getTime();
    }

    /**
     * @desc 将时间转换为标准的yyyy-MM-dd HH:mm:ss格式
     * @params [date]
     * @returnDesc
     * @author 古力 2018/10/14 上午11:29
     */
    public static String date2String(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * @desc 返回当天是一周中的第几天，1是周一，7是周日
     * @params []
     * @returnDesc
     * @author 古力 2018/10/18 下午7:45
     */
    public static int dayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (0 == dayOfWeek) {
            dayOfWeek = 7;
        }
        return dayOfWeek;
    }

    /**
     * 获取时间戳
     *
     * @param dateTime
     * @return
     */
    public static long getTimestampByLocalDateTime(LocalDateTime dateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = dateTime.atZone(zone).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * String->LocalDateTime
     */
    public static LocalDateTime strToLocalDateTime(String dateTime){
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     *
     * 功能描述:
     *      由于前端传过来的日期格式不符合yyyy-MM-dd，故需要转为该格式
     *
     * @param:
     * @return:
     * @auther: liuyangfu
     * @date: 2018/12/29 下午12:19
     */
    public static String timeFormatParse(String dateTime) {
        StringBuilder builder = new StringBuilder();

        String[] dates = dateTime.split("\\-");
        builder.append(dates[0]);

        for(int i = 1; i < dates.length; i++) {
            if(dates[i].length() == 1) {
                builder.append("-0" + dates[i]);
            } else {
                builder.append("-" + dates[i]);
            }
        }

        return builder.toString();
    }

    /**localDateTime 转化为前端格式 yyyy-MM-dd HH:mm:ss
     * author @yanyang
     */
    public static String timeToStr(LocalDateTime time){
        DateTimeFormatter noTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String noStr = time.format(noTime);
        return noStr;
    }

    /**
     *
     * 功能描述:
     *      获取格式为yyyyMMdd的日期格式
     *
     * @param:
     * @return:
     * @auther: liuyangfu
     * @date: 2019/1/23 下午4:32
     */
    public static String parseTimeFormat(String dateTime) {
        StringBuilder builder = new StringBuilder();

        String[] dates = dateTime.split("\\-");
        builder.append(dates[0]);

        for(int i = 1; i < dates.length; i++) {
            if(dates[i].length() == 1) {
                builder.append("0" + dates[i]);
            } else {
                builder.append(dates[i]);
            }
        }

        return builder.toString();
    }

    /**
     * @desc: 比较两个时间的大小
     * @param:
     * @return: boolean
     * @auther: AnYuan
     * @date: 2019-02-28
     */
    public static boolean compareDate(String DATE1, String DATE2){
        Integer res = DATE1.compareTo(DATE2);
        return res > 0;
    }

    /**
     * @desc: yyyyMMddHHmmss时间格式转化为yyyy-MM-hhmmss
     * @param:
     * @return:
     * @auther: AnYuan
     * @date: 2019-03-04
     */
    public static LocalDateTime strDataToLocalDate(String dateString){
        return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
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
