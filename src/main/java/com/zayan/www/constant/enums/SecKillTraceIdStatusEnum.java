package com.zayan.www.constant.enums;

import lombok.Getter;

/**
 * 秒杀状态
 * @author AnYuan
 * @date 2021-01-07
 */

@Getter
public enum SecKillTraceIdStatusEnum {

    /**
     * 秒杀状态
     */

    NO_SUBMIT("NO_SUBMIT", "未下单"),
    SUBMIT("SUBMIT", "已下单"),
    FAIL("FAIL", "已失败"),
    PAID("PAID", "已支付"),
    ;

    private String code;
    private String message;

    SecKillTraceIdStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
