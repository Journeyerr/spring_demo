package com.zayan.www.exception;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义异常类需要继承
 * @author AnYuan
 */

public abstract class BaseBizException extends RuntimeException {

    private Integer code;

    protected BaseBizException(Integer code, String message){
        super(message);
        this.code = code;
    }

    protected BaseBizException(String message){
        super(message);
        this.code = -1;
    }

    /**
     *
     */
    @Override
    public Throwable fillInStackTrace()
    {
        return this;
    }
}
