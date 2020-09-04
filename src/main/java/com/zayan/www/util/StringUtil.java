package com.zayan.www.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}
