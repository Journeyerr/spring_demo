package com.zayan.www.exception;

import com.zayan.www.constant.enums.ErrorEnum;

public class UserExcetpion extends BaseException {

    public UserExcetpion(ErrorEnum errorEnum){
        super(errorEnum.getCode(), errorEnum.getMessage());
    };
}
