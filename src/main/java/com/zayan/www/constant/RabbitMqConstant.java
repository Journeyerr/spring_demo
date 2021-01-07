package com.zayan.www.constant;

/**
 * rabbitMq 配置
 * @author AnYuan
 * @date 2020-10-26
 */

public interface RabbitMqConstant {

    String SECKILL_ORDER_TRACE_EXCHANGE = "zay.seckill.order.trace.exchange";
    String SECKILL_ORDER_TRACE_QUEUE = "zay.seckill.order.trace.queue";
    String USER_EXCHANGE = "user_exchange";
    String USER_ROUTING_KEY = "user_routing_key";
    String USER_QUEUE = "user_queue";
}
