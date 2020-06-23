package com.zayan.www.config.rabbitMq;

import com.zayan.www.constant.enums.RabbitMqMessageConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Configuration;

/**
 * @author AnYuan
 * @date 03-12
 */

@Configuration
@Slf4j
public class UserQueueConfig {


//    @Bean
    public Queue userMassageQueue() {
        log.info("userMassageQueue init");
        return new Queue(RabbitMqMessageConstant.USER_QUEUE);
    }

//    @Bean
    public DirectExchange userMassageExchange() {
        log.info("userMassageExchange init");
        return new DirectExchange(RabbitMqMessageConstant.USER_EXCHANGE);
    }

//    @Bean
    public Binding queueBindingExchange() {
        log.info("queueBindingExchange init");
        return BindingBuilder.bind(userMassageQueue())
                .to(userMassageExchange()).with("");
    }
}
