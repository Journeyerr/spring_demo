package com.zayan.www.exception;

import com.google.common.collect.Maps;
import com.zayan.www.constant.enums.ErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
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
        Map<String, Object> map = Maps.newHashMapWithExpectedSize(2);
        map.put("code", ErrorEnum.SERVICE_ERROR.getCode());
        map.put("msg", e.getMessage());
        return map;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String, Object> ValidExceptionHandle(MethodArgumentNotValidException exception){
        BindingResult result = exception.getBindingResult();
        Map<String, Object> map = Maps.newHashMapWithExpectedSize(2);

        map.put("code", ErrorEnum.PARAM_ERROR.getCode());
        map.put("msg", ErrorEnum.PARAM_ERROR.getMessage());
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            fieldErrors.forEach(error -> {
                map.put("msg", error.getDefaultMessage());
            });
        }else {

        }
        exception.printStackTrace();
        return map;
    }
}
