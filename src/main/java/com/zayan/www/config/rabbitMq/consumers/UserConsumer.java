package com.zayan.www.config.rabbitMq.consumers;

import com.alibaba.fastjson.JSONObject;
import com.zayan.www.constant.enums.RabbitMqMessageConstant;
import com.zayan.www.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * rabbit 消费
 * @author AnYuan
 * @date 03-14
 */

//@Component
@Slf4j
public class UserConsumer {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = RabbitMqMessageConstant.USER_QUEUE, durable = "true"),
            exchange = @Exchange(value = RabbitMqMessageConstant.USER_EXCHANGE)
    ))
    public void onMassageUser(Message message) {
        log.info("UserConsumer 开始消费----->{}", message);
        User user = JSONObject.parseObject(new String(message.getBody()), User.class);
        log.info("userName------>{}", user.getName());
    }
}
