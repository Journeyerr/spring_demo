package com.zayan.www.constant.enums;

import lombok.Getter;

/**
 * @author AnYuan
 */

@Getter
public enum SecKillOrderStatusEnum {

    /**
     * 错误码
     */
    WAIT_PAY("WAIT_PAY", "等待支付"),
    PAID("PAID", "已经支付"),
    ;

    private String code;
    private String message;

    SecKillOrderStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


}
