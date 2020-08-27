package com.zayan.www.config.web;

import com.zayan.www.util.RequestUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class TokenInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Integer userIdFormContextToken = RequestUtil.getUserIdFormContextToken();
        return Objects.nonNull(userIdFormContextToken);
    }
}
