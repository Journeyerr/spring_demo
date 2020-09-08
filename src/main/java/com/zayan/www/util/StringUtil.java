package com.zayan.www.util;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringUtil {

    /**
     * 验证手机号
     * @param phone phone
     * @return bool
     */
    public static boolean isMobile(String phone) {

        String s2 = "^[1](([3][0-9])|([4][5,7,9])|([5][0-9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";
        if(StringUtils.isNoneBlank(phone)){
            Pattern pattern = Pattern.compile(s2);
            Matcher matcher = pattern.matcher(phone);
            return matcher.matches();
        }
        return false;
    }

    /**
     * 生成订单号
     * @return String
     */
    public static String no() {
        String yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());
        Random random = new Random();
        int asInt = random.ints(1000, 9999).findFirst().getAsInt();
        return yyyyMMddHHmmss.concat(String.valueOf(asInt));
    }
}
