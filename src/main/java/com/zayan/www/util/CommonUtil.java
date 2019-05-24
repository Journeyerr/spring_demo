package com.zayan.www.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author 古力
 * @Date 2018/10/11 下午3:01
 */
public class CommonUtil {
    /**
     * 生成单号，时间+6位微秒数+3位随机数
     *
     * @return
     */
    public static String createOutRefundNo() {
        //SimpleDateFormat只能精确到三位毫秒，前三个S会以0补位
        String no = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS").format(new Date()) + (int) (Math.random() * (899) + 100);
        return no;
    }

    public static String createOrderNo(String shopNo, String pickupNo) {
        StringBuilder orderNoSb = new StringBuilder(shopNo);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        if (hour > 6) {
            orderNoSb.append(sdf.format(calendar.getTime()));
        } else {
            calendar.add(Calendar.DATE, -1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            orderNoSb.append(sdf.format(calendar.getTime()));
        }
        orderNoSb.append(pickupNo);
        return orderNoSb.toString();
    }

    /**
     * 生成product的no 时间+10位随机数 如:190218 + 10位随机数
     *
     **/
    public static String createProductNo() {
        return new SimpleDateFormat("yyMMdd").format(new Date())+getRandomNum(10);
    }

    /**
     * @desc 为电话号码加密（取出最后一位数字，找到数字对应位置插入，机密，取下标为8开始往后的16位）
     * @params [phone]
     * @returnDesc
     * @author 古力 2018/10/23 下午6:00
     */
    public static String encryptPhone(String phone) {
        if (StringUtils.isNumeric(phone)) {
            String lastStr = phone.substring(phone.length() - 1);
            int lastNum = Integer.parseInt(lastStr);
            String raw = new StringBuilder()
                    .append(phone, 0, lastNum - 1)
                    .append(lastStr)
                    .append(phone, lastNum - 1, phone.length() - 1).toString();
            return DigestUtils.md5Hex(raw).substring(8, 24);
        } else {
            return DigestUtils.md5Hex(phone).substring(8, 24);
        }
    }

    /**
     * @desc 获得指定位数的随机数
     * @params [places]
     * @returnDesc
     * @author 古力 2018/12/13 9:06 PM
     */
    public static String getRandomNum(int count) {
        return RandomStringUtils.randomNumeric(count);
    }

    /**
     * @desc 将源分页对象转换为指定list的分页对象
     * @params [sourcePage, targetList] sourcePage：源分页对象   targetList：目标分页对象需要的内容
     * @returnDesc
     * @author 古力 2018/12/29 12:01 PM
     */
    public static <S, T> IPage<T> pageConvert(IPage<S> sourcePage, List<T> targetList) {
        Page<T> tPage = new Page<>();
        BeanUtils.copyProperties(sourcePage, tPage);
        return tPage.setRecords(targetList);
    }

    public static String chineseToUnicode(String str) {
        if (null == str) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int chr1 = (int) str.charAt(i);
            //汉字范围 \u4e00-\u9fa5 (中文)
            if (chr1 >= 19968 && chr1 <= 171941) {
                result.append("\\u").append(Integer.toHexString(chr1));
            } else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
