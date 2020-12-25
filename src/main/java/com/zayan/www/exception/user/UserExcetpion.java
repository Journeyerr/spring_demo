package com.zayan.www.exception.user;

import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.BaseException;

public class UserExcetpion extends BaseException {

    public UserExcetpion(ErrorEnum errorEnum) {
        super(errorEnum);
    }

    ;
}
