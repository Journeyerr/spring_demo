package com.zayan.www.exception;

import com.zayan.www.constant.enums.ErrorEnum;

public class UploadException extends BaseException {

    public UploadException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
