package com.zayan.www.rabbitmq.config;

import com.zayan.www.constant.RabbitMqConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;

/**
 * @author AnYuan
 * @date 03-12
 */

//@Configuration
@Slf4j
public class UserQueueConfig {


    //    @Bean
    public Queue userMassageQueue() {
        log.info("userMassageQueue init");
        return new Queue(RabbitMqConstant.USER_QUEUE);
    }

    //    @Bean
    public DirectExchange userMassageExchange() {
        log.info("userMassageExchange init");
        return new DirectExchange(RabbitMqConstant.USER_EXCHANGE);
    }

    //    @Bean
    public Binding queueBindingExchange() {
        log.info("queueBindingExchange init");
        return BindingBuilder.bind(userMassageQueue())
                .to(userMassageExchange()).with("");
    }
}
