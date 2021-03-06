package com.zayan.www.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringUtil {

    /**
     * 验证手机号
     *
     * @param phone phone
     * @return bool
     */
    public static boolean isMobile(String phone) {

        String s2 = "^[1](([3][0-9])|([4][5,7,9])|([5][0-9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";
        if (StringUtils.isNoneBlank(phone)) {
            Pattern pattern = Pattern.compile(s2);
            Matcher matcher = pattern.matcher(phone);
            return matcher.matches();
        }
        return false;
    }

    /**
     * 生成订单号
     *
     * @return String
     */
    public static String no() {
        String yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());
        Random random = new Random();
        int asInt = random.ints(1000, 9999).findFirst().getAsInt();
        return yyyyMMddHHmmss.concat(String.valueOf(asInt));
    }

    /**
     * md5加密
     *
     * @return String
     */
    public static String md5(String string) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(string.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            throw new RuntimeException("加密出现错误");
        }
    }

    /**
     * 获取uuid
     * @param count 长度 min 1, max 32
     * @return string
     */
    public static String getUuid(Integer count) {
        return UUID.randomUUID().toString().replace("-", "").substring(0,count);
    }
}
