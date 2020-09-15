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


    WAIT_BUYER_PAY("WAIT_BUYER_PAY", "等待用户付款"),
    BUYER_PAY("BUYER_PAY", "用户已付款"),
    WAIT_SELLER_SEND_GOODS("WAIT_SELLER_SEND_GOODS", "商家准备中"),
    WAIT_BUYER_CONFIRM_GOODS("WAIT_BUYER_CONFIRM_GOODS", "等待用户确认收货"),
    DISPATCHING_GOODS("DISPATCHING_GOODS", "配送中"),
    TRADE_CLOSED("DISPATCHING_GOODS", "交易完成"),
    CANCELED("DISPATCHING_GOODS", "交易取消"),
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
