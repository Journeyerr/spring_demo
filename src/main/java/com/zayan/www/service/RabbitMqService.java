package com.zayan.www.service;

/**
 * rabbimq服务
 * @author AnYuan
 */
public interface RabbitMqService {

    /**
     * 统一发送mq
     *
     * @param exchange   交换机
     * @param routingKey 路由key
     * @param data       数据
     */
    void send(String exchange, String routingKey, Object data);

    /**
     * 秒杀
     * @param body body
     */
    void sendSecKillOrderExchange(String body);

    /**
     * 统一发送mq
     *
     * @param exchange   交换机
     * @param routingKey 路由key
     * @param data       数据
     */
    void ttlSend(String exchange, String routingKey, Object data, Integer ttl);
}
