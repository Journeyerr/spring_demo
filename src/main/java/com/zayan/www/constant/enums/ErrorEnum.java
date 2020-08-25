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
    TOKEN_EXCEPTION(1004, "身份信息异常"),
    NO_FOUND(1010, "查询为空"),
    PARAM_ERROR(1011, "参数错误"),
    UPDATE_FAIL(1012, "操作失败"),
    USER_EXCEPTION(1013, "用户异常"),
    DATA_ERROR(1014, "数据异常"),
    ACCOUNT_ERROR(1015, "账号或密码错误"),

    FILE_ERROR(1030, "文件错误"),
    FILE_UPLOAD_DIR_ERROR(1031, "文件路径错误"),
    FILE_UPLOAD_ERROR(1032, "文件上传失败"),

    ;

    private Integer code;
    private String message;

    ErrorEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }


}
