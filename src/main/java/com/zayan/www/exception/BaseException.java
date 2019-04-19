package com.zayan.www.exception;

import com.zayan.www.constant.enums.ErrorEnum;
import lombok.Data;

/**
 * @author AnYuan
 */

@Data
public class BaseException extends RuntimeException {

    private Integer code;
    private String message;

    public BaseException(ErrorEnum errorEnum){
        super(errorEnum.getMessage());
        this.code = errorEnum.getCode();
    }

    public BaseException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public BaseException(String message, Throwable throwable){
        super(message, throwable);
    }

    /**
     *
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
