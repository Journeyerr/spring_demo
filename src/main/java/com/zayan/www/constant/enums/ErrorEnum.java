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
    TOKEN_EXCEPTION(1001, "身份信息异常"),
    UNAUTHORIZED(1002, "未认证"),
    SERVICE_ERROR(1003, "服务异常"),

    PARAM_ERROR(1010, "参数错误"),
    NO_FOUND(1011, "查询为空"),
    UPDATE_FAIL(1012, "操作失败"),
    USER_EXCEPTION(1013, "用户异常"),
    DATA_ERROR(1014, "数据异常"),
    ACCOUNT_ERROR(1015, "账号或密码错误"),

    FILE_ERROR(1030, "文件错误"),
    FILE_UPLOAD_DIR_ERROR(1031, "文件路径错误"),
    FILE_UPLOAD_ERROR(1032, "文件上传失败"),


    PHONE_ERROR(1040, "手机号格式不正确"),
    ADDRESS_NAME_ERROR(1041, "联系人不能为空"),
    ADDRESS_ERROR(1042, "该地址可能无法准确配送"),

    ORDER_PRODUCT_ERROR(1060, "商品信息错误"),
    ORDER_PRODUCT_PRICE_ERROR(1061, "商品价格错误"),
    ORDER_TOTAL_FEE_ERROR(1062, "订单总价错误"),
    ORDER_ADDRESS_ERROR(1063, "配送地址异常"),


    EDIT_PASSWORD_ERROR(1070, "密码错误"),
    EDIT_PASSWORD_NO_EQUALS(1070, "两次密码不一致"),


    ;

    private Integer code;
    private String message;

    ErrorEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
