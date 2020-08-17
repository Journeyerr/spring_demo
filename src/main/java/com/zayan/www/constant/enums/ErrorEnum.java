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
    UNAUTHORIZED(1001, "未认证"),
    TOKEN_EXCEPTION(1004, "Token Exception"),
    NO_FOUND(1010, "查询为空"),
    UPDATE_FAIL(1012, "操作失败"),
    USER_EXCEPTION(1013, "用户异常"),
    DATA_ERROR(1014, "数据异常"),
    ACCOUNT_ERROR(1015, "账号或密码错误"),

    ;

    private Integer code;
    private String message;

    ErrorEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }


}
