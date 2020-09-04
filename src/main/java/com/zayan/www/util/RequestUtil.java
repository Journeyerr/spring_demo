package com.zayan.www.util;

import com.alibaba.fastjson.JSONObject;
import com.zayan.www.constant.CommonConstant;
import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.auth.UnAuthorizedException;
import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author AnYuan
 */

@Slf4j
public class RequestUtil {

    public static Integer getUserIdFormContextToken(){
        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.currentRequestAttributes()).getRequest();
        try {
            Base64 decode = new Base64();
            String[] split = request.getHeader(CommonConstant.REQUEST_HEADER_NAME).split("\\.");
            String token = new String(decode.decode(split[1]));
            JSONObject jsonObject = JSONObject.parseObject(token).getJSONObject("user");
            return jsonObject.getInteger("userId");
        }catch (Exception e) {
            throw new UnAuthorizedException(ErrorEnum.TOKEN_EXCEPTION);
        }
    }
}
