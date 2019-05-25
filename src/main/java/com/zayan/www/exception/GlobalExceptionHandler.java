package com.zayan.www.exception;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler{

    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public Map<String, Object> exceptionHandler(BaseException e) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("code", e.getCode());
        map.put("msg", e.getMessage());
        return map;
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> exceptionHandler(Exception e) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("code", 1002);
        map.put("msg", e.getMessage());
        return map;
    }
}
