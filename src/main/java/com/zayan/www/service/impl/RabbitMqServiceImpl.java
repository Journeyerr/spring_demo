package com.zayan.www.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zayan.www.constant.RabbitMqConstant;
import com.zayan.www.service.RabbitMqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * rabbitmq服务
 * @author AnYuan
 */

@Service
@Slf4j
public class RabbitMqServiceImpl implements RabbitMqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String exchange, String routingKey, Object data) {
        rabbitTemplate.convertAndSend(exchange, routingKey, JSONObject.toJSONString(data));
    }

    @Override
    public void sendSecKillOrderExchange(String body) {
        log.info("SecKill Order Exchange:{}", body);
        rabbitTemplate.send(RabbitMqConstant.SECKILL_ORDER_TRACE_EXCHANGE,
                "",
                MessageBuilder
                        .withBody(body.getBytes())
                        .setContentType("application/json")
                        .build()
        );
    }

    @Override
    public void ttlSend(String exchange, String routingKey, Object data, Integer ttl) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setExpiration(ttl.toString());
        Message message = new Message(JSONObject.toJSONString(data).getBytes(), messageProperties);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
