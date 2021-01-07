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

    WAIT("WAIT", "未下单"),
    SUCCESS("SUCCESS", "已成功"),
    FAIL("FAIL", "已失败"),
    ;

    private String code;
    private String message;

    SecKillTraceIdStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
