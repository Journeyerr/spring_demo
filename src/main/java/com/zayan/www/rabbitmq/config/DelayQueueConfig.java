package com.zayan.www.rabbitmq.config;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * RabbitMq 延时队列实现
 * @author AnYuan
 */

@Slf4j
@Configuration
public class DelayQueueConfig {

    /**
     * 延迟队列
     */
    public static final String DELAY_EXCHANGE = "delay.queue.business.exchange";
    public static final String DELAY_QUEUE = "delay.queue.business.queue";
    public static final String DELAY_QUEUE_ROUTING_KEY = "delay.queue.business.queue.routingKey";

    /**
     * 死信队列
     */
    public static final String DEAD_LETTER_EXCHANGE = "delay.queue.deadLetter.exchange";
    public static final String DEAD_LETTER_QUEUE_ROUTING_KEY = "delay.queue.deadLetter.delay_10s.routingKey";
    public static final String DEAD_LETTER_QUEUE = "delay.queue.deadLetter.queue";

    /**
     * 声明 死信交换机
     * @return deadLetterExchange
     */
    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(DEAD_LETTER_EXCHANGE);
    }

    /**
     * 声明 死信队列 用于接收死信消息
     * @return deadLetterQueueA
     */
    @Bean
    public Queue deadLetterQueueA() {
        return new Queue(DEAD_LETTER_QUEUE);
    }

    /**
     *  将 死信队列 绑定到死信交换机上
     * @return deadLetterBindingA
     */
    @Bean
    public Binding deadLetterBindingA() {
        return BindingBuilder
                .bind(deadLetterQueueA())
                .to(deadLetterExchange())
                .with(DEAD_LETTER_QUEUE_ROUTING_KEY);
    }

    /**
     * 声明 延时交换机
     * @return delayExchange
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DELAY_EXCHANGE);
    }

    /**
     * 将 延时队列 绑定参数
     * @return Queue
     */
    @Bean
    public Queue delayQueueA() {
        Map<String, Object> maps = Maps.newHashMapWithExpectedSize(3);
        // 队列绑定DLX参数（关键一步）
        maps.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
        // 队列绑定 死信RoutingKey参数
        maps.put("x-dead-letter-routing-key", DEAD_LETTER_QUEUE_ROUTING_KEY);
        // 队列的 ttl 时间，单位：毫秒 ，这里设置的8秒
        maps.put("x-message-ttl", 8000);
        return QueueBuilder.durable(DELAY_QUEUE).withArguments(maps).build();
    }

    /**
     * 将 延时队列 绑定到延时交换机上面
     * @return delayBindingA
     */
    @Bean
    public Binding delayBindingA() {
        return BindingBuilder
                .bind(delayQueueA())
                .to(directExchange())
                .with(DELAY_QUEUE_ROUTING_KEY);
    }
}
