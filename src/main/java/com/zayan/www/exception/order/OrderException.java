package com.zayan.www.exception.order;

import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.BaseException;

/**
 * @author AnYuan
 */

public class OrderException extends BaseException {

    public OrderException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
