package com.zayan.www.rabbitmq.consumers;

import com.alibaba.fastjson.JSONObject;
import com.zayan.www.rabbitmq.config.DelayQueueConfig;
import com.zayan.www.util.DateUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.util.DataUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 延时队列消息消费者
 *
 * @author AnYuan
 * @date 2020-06-23
 */

@Component
@Slf4j
public class DelayMsgConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(DelayQueueConfig.DEAD_LETTER_QUEUE),
            exchange = @Exchange(DelayQueueConfig.DEAD_LETTER_EXCHANGE)))
    public void queueAConsumer(Message message) {
        Msg msg = JSONObject.parseObject(new String(message.getBody()), Msg.class);

        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(msg.getDate(), now);

        log.info("DelayMsgConsumer死信队列消费----> 发送时间:{}, 当前时间:{}, ttl:{},  相差时间：{}秒",  DateUtil.localDateTimeToString(msg.getDate()), DateUtil.localDateTimeToString(now), msg.getTtl(), duration.getSeconds());
    }

    @Data
    public static class Msg {
        private String ttl;
        private String msg;
        private LocalDateTime date;
    }
}
