package com.zayan.www.constant.enums;

import lombok.Getter;

/**
 * @author AnYuan
 */

@Getter
public enum ErrorEnum {

    /**
     * 错误码
     */
    UNAUTHORIZED(1002, "未认证"),
    NO_FOUND(1003, "查询为空"),
    TOKEN_EXCEPTION(1004, "查询为空"),
    USER_EXCEPTION(1005, "用户异常"),


    ;

    private Integer code;
    private String message;

    ErrorEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }


}
