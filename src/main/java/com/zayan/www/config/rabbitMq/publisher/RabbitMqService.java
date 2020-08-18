package com.zayan.www.config.rabbitMq.publisher;

/**
 * @author AnYuan
 * @date 03-12
 */

public interface RabbitMqService<T> {

    /**
     * 统一发送mq
     * @param exchange 交换机
     * @param routingKey 路由key
     * @param data 数据
     */
    void send(String exchange, String routingKey, T data);
}
