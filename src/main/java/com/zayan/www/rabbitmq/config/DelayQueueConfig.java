package com.zayan.www.rabbitmq.config;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.rmi.runtime.Log;

import java.util.Map;

/**
 * RabbitMq死信队列简单实现
 * @author AnYuan
 */

@Slf4j
@Configuration
public class DelayQueueConfig {

    /**
     * mq消息推送到延迟队列，过期后转发到死信队列，直接消费死信队列即可
     */

    public static final String DELAY_EXCHANGE = "delay.queue.business.exchange";
    public static final String DELAY_QUEUE = "delay.queue.business.queue";
    public static final String DELAY_QUEUE_ROUTING_KEY = "delay.queue.business.queue.routingKey";

    public static final String DEAD_LETTER_EXCHANGE = "delay.queue.deadLetter.exchange";
    public static final String DEAD_LETTER_QUEUE_ROUTING_KEY = "delay.queue.deadLetter.delay_10s.routingKey";
    public static final String DEAD_LETTER_QUEUE = "delay.queue.deadLetter.queue";

    /**
     * 声明 延迟队列交换机
     * @return delayExchange
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DELAY_EXCHANGE);
    }

    /**
     * 声明 延迟队列交换机
     * @return deadLetterExchange
     */
    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(DEAD_LETTER_EXCHANGE);
    }

    /**
     * 将 延迟队列 绑定过期后要转发的死信 Exchange，routingKey
     * @return Queue
     */

    @Bean
    public Queue delayQueueA() {
        Map<String, Object> maps = Maps.newHashMapWithExpectedSize(3);
        // 延迟队列A绑定死信交换机
        maps.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
        // 延迟队列A绑定死信key
        maps.put("x-dead-letter-routing-key", DEAD_LETTER_QUEUE_ROUTING_KEY);
        // 队列的 ttl
//        maps.put("x-message-ttl", 6000);
        return QueueBuilder.durable(DELAY_QUEUE).withArguments(maps).build();
    }

    /**
     * 声明 死信队列 用于接收过期的消息
     * @return deadLetterQueueA
     */
    @Bean
    public Queue deadLetterQueueA() {
        return new Queue(DEAD_LETTER_QUEUE);
    }


    /**
     * 将 队列 绑定到延迟交换机上面
     * @return delayBindingA
     */
    @Bean
    public Binding delayBindingA() {
        log.info("delayBindingA---Init");
        return BindingBuilder
                .bind(delayQueueA())
                .to(directExchange())
                .with(DELAY_QUEUE_ROUTING_KEY);
    }

    /**
     *  将 死信队列 绑定到死信交换机上
     * @return deadLetterBindingA
     */
    @Bean
    public Binding deadLetterBindingA() {
        log.info("deadLetterBindingA---Init");
        return BindingBuilder
                .bind(deadLetterQueueA())
                .to(deadLetterExchange())
                .with(DEAD_LETTER_QUEUE_ROUTING_KEY);
    }
}
