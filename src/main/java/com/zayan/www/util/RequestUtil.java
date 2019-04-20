package com.zayan.www.util;

import com.alibaba.fastjson.JSONObject;
import com.zayan.www.constant.enums.CommonConstant;
import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.BaseException;
import com.zayan.www.exception.auth.UnAuthorizedException;
import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author AnYuan
 */

@Slf4j
public class RequestUtil {

    private static HttpServletRequest getRequestFormContextHolder(){
       try {
           HttpServletRequest request = ((ServletRequestAttributes)
                   RequestContextHolder.currentRequestAttributes()).getRequest();
           Assert.notNull(request);
           return request;
       }catch (RuntimeException e){
           throw new BaseException("request 解析错误", e);
       }
    }

    private static String getTokenFromRequest(){
        HttpServletRequest request = getRequestFormContextHolder();
        String token = request.getHeader(CommonConstant.REQUEST_HEADER_NAME);
        if (token.startsWith(CommonConstant.TOKEN_PREFIX)) {
            token = token.substring(CommonConstant.TOKEN_PREFIX.length(), token.length());
        }
        String[] split = token.split("\\.");
        Assert.isTrue(split.length > 1, "无法获取到token主体，请检查token: "+token);
        Base64 decode = new Base64();
        return new String(decode.decode(split[1]));
    }

    public static Integer getUserInfoByToken(){
        try {
            String token = getTokenFromRequest();
            JSONObject jsonObject = JSONObject.parseObject(token).getJSONObject("user");
            Integer userId = jsonObject.getInteger("userId");
            if (userId == null){
                throw new UnAuthorizedException(ErrorEnum.UNAUTHORIZED);
            }
            return userId;
        }catch (RuntimeException e){
            throw new UnAuthorizedException(ErrorEnum.UNAUTHORIZED);
        }
    }
}
