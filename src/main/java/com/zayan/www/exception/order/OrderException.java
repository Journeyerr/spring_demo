package com.zayan.www.exception.order;

import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.BaseBizException;

public class OrderException extends BaseBizException {

    public OrderException(ErrorEnum errorEnum){
        super(errorEnum.getCode(), errorEnum.getMessage());
    }
}
