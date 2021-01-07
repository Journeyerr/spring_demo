package com.zayan.www.rabbitMq.consumers;

import com.alibaba.fastjson.JSONObject;
import com.zayan.www.rabbitMq.config.DelayQueueConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.time.LocalDateTime;

/**
 * 延时队列消息消费者
 *
 * @author AnYuan
 * @date 2020-06-23
 */

//@Component
@Slf4j
public class DelayMsgConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(DelayQueueConfig.DEAD_LETTER_QUEUEA),
            exchange = @Exchange(DelayQueueConfig.DEAD_LETTER_EXCHANGE)))
    public void queueAConsumer(Message message) {
        log.info("DelayMsgConsumer 延时队列AAAAA 开始消费-----> {}", message);
        Msg msg = JSONObject.parseObject(new String(message.getBody()), Msg.class);
        log.info("DelayMsgConsumer 延时队列AAAA 结果----> {}", msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(DelayQueueConfig.DEAD_LETTER_QUEUEB),
            exchange = @Exchange(DelayQueueConfig.DEAD_LETTER_EXCHANGE)))
    public void queueBConsumer(Message message) {
        log.info("DelayMsgConsumer 延时队列BBBBB 开始消费-----> {}", message);
        JSONObject jsonObject = JSONObject.parseObject(new String(message.getBody()));
        log.info("DelayMsgConsumer 延时队列BBBBB 结果----> {}", jsonObject);
    }

    @Data
    public static class Msg {

        private Integer type;
        private String msg;
        private LocalDateTime date;
    }

}
