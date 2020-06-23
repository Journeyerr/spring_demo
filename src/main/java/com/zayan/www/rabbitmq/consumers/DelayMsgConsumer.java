package com.zayan.www.rabbitmq.consumers;

import com.alibaba.fastjson.JSONObject;
import com.zayan.www.config.rabbitMq.DelayQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 延时队列消息消费者
 * @author AnYuan
 * @date 2020-06-23
 */

@Component
@Slf4j
public class DelayMsgConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(DelayQueueConfig.DEAD_LETTER_QUEUEA),
            exchange = @Exchange(DelayQueueConfig.DEAD_LETTER_EXCHANGE)))
    public void queueAConsumer(Message message) {
        log.info("DelayMsgConsumer 延时队列AAAAA 开始消费-----> {}", message);
        JSONObject jsonObject = JSONObject.parseObject(new String(message.getBody()));
        log.info("DelayMsgConsumer 延时队列AAAA 结果----> {}", jsonObject);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(DelayQueueConfig.DEAD_LETTER_QUEUEB),
            exchange = @Exchange(DelayQueueConfig.DEAD_LETTER_EXCHANGE)))
    public void queueBConsumer(Message message) {
        log.info("DelayMsgConsumer 延时队列BBBBB 开始消费-----> {}", message);
        JSONObject jsonObject = JSONObject.parseObject(new String(message.getBody()));
        log.info("DelayMsgConsumer 延时队列BBBBB 结果----> {}", jsonObject);
    }

}
