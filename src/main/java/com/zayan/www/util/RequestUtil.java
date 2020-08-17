package com.zayan.www.util;

import com.alibaba.fastjson.JSONObject;
import com.zayan.www.constant.enums.CommonConstant;
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
        Assert.notNull(request);
        String tokenStr = request.getHeader(CommonConstant.REQUEST_HEADER_NAME);
        if (Objects.isNull(tokenStr) || !tokenStr.startsWith(CommonConstant.TOKEN_PREFIX)) {
            throw new UnAuthorizedException(ErrorEnum.TOKEN_EXCEPTION);
        }
        String[] split = tokenStr.split("\\.");
        if (split.length < 2) {
            throw new UnAuthorizedException(ErrorEnum.TOKEN_EXCEPTION);
        }
        Base64 decode = new Base64();
        String token = new String(decode.decode(split[1]));

        JSONObject jsonObject = JSONObject.parseObject(token).getJSONObject("user");
        Integer userId = jsonObject.getInteger("userId");
        if (Objects.isNull(userId)){
            throw new UnAuthorizedException(ErrorEnum.UNAUTHORIZED);
        }
        return userId;
    }
}
