package com.zayan.www.constant.enums;

import lombok.Getter;

/**
 * @author AnYuan
 */

@Getter
public enum ErrorEnum {

    /**
     * 未认证
     */
    UNAUTHORIZED(1002, "未认证"),
    /**
     * 查询为空
     */
    NO_FOUND(1003, "查询为空"),


    ;

    private Integer code;
    private String message;

    ErrorEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }


}
