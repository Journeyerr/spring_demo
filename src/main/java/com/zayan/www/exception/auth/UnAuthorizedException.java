package com.zayan.www.exception.auth;

import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.BaseException;

/**
 * @author AnYuan
 */

public class UnAuthorizedException extends BaseException {

    public UnAuthorizedException(String message, Throwable throwable){
        super(message, throwable);
    }

    public UnAuthorizedException(ErrorEnum errorEnum){
        super(errorEnum);
    }
}
