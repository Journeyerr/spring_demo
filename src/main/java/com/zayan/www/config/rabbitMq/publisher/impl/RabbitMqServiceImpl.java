package com.zayan.www.config.rabbitMq.publisher.impl;

import com.alibaba.fastjson.JSONObject;
import com.zayan.www.config.rabbitMq.publisher.RabbitMqService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * rabbitmq 服务
 * @author AnYuan
 * @date 2020-06-23
 */

@Service
public class RabbitMqServiceImpl implements RabbitMqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String exchange, String routingKey, Object data) {
        rabbitTemplate.convertAndSend(exchange, routingKey, JSONObject.toJSONString(data));
    }
}
