package com.zayan.www.constant.enums;

import lombok.Getter;

/**
 * 订单状态类型
 * @author AnYuan
 * @date 2020-09-15
 */

@Getter
public enum  OrderStatusEnum {

    /**
     * code code name
     */


    WAIT_BUYER_PAY("WAIT_BUYER_PAY", "用户未付款"),
    BUYER_PAY("BUYER_PAY", "用户已付款"),
    WAIT_SELLER_SEND_GOODS("WAIT_SELLER_SEND_GOODS", "正在备货中"),
    WAIT_BUYER_CONFIRM_GOODS("WAIT_BUYER_CONFIRM_GOODS", "等待收货"),
    DISPATCHING_GOODS("DISPATCHING_GOODS", "正在配送中"),
    TRADE_CLOSED("DISPATCHING_GOODS", "交易已完成"),
    CANCELED("DISPATCHING_GOODS", "交易已取消"),
    ;

    private final String code;
    private final String message;

    OrderStatusEnum(String code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public static String getMsgByCode(String code){
        for (OrderStatusEnum value : OrderStatusEnum.values()) {
            if(value.code.equals(code)){
                return value.getMessage();
            }
        }
        return WAIT_BUYER_PAY.getMessage();
    }
}
