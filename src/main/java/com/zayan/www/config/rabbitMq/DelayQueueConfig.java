package com.zayan.www.config.rabbitMq;

import com.google.common.collect.Maps;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class DelayQueueConfig {

    public static final String DELAY_EXCHANGE = "delay.queue.demo.business.exchange";
    public static final String DELAY_QUEUEA = "delay.queue.demo.business.queuea";
    public static final String DELAY_QUEUEB = "delay.queue.demo.business.queueb";
    public static final String DELAY_QUEUEA_ROUTING_KEY = "delay.queue.demo.business.queuea.routingkey";
    public static final String DELAY_QUEUEB_ROUTING_KEY = "delay.queue.demo.business.queueb.routingkey";
    public static final String DEAD_LETTER_EXCHANGE = "delay.queue.demo.deadletter.exchange";
    public static final String DEAD_LETTER_QUEUEA_ROUTING_KEY = "delay.queue.demo.deadletter.delay_10s.routingkey";
    public static final String DEAD_LETTER_QUEUEB_ROUTING_KEY = "delay.queue.demo.deadletter.delay_60s.routingkey";
    public static final String DEAD_LETTER_QUEUEA = "delay.queue.demo.deadletter.queuea";
    public static final String DEAD_LETTER_QUEUEB = "delay.queue.demo.deadletter.queueb";

    /**
     * 声明延迟 Exchange
     * @return delayExchange
     */
    @Bean("delayExchange")
    public DirectExchange directExchange() {
        return new DirectExchange(DELAY_EXCHANGE);
    }

    /**
     * 声明死信队列
     * @return deadLetterExchange
     */
    @Bean("deadLetterExchange")
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(DEAD_LETTER_EXCHANGE);
    }

    @Bean("delayQueueA")
    public Queue delayQueueA() {
        Map<String, Object> maps = Maps.newHashMapWithExpectedSize(3);
        // 当前队列绑定死信交换机
        maps.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
        // 当前队列绑定死信key
        maps.put("x-dead-letter-routing-key", DEAD_LETTER_QUEUEA_ROUTING_KEY);
        // 队列的 ttl
        maps.put("x-message-ttl", 6000);

        return QueueBuilder.durable(DELAY_QUEUEA).withArguments(maps).build();
    }

    @Bean("delayQueueB")
    public Queue delayQueueB() {
        Map<String, Object> maps = Maps.newHashMapWithExpectedSize(3);
        // 当前队列绑定死信交换机
        maps.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
        // 当前队列绑定死信key
        maps.put("x-dead-letter-routing-key", DEAD_LETTER_QUEUEB_ROUTING_KEY);
        // 队列的 ttl
        maps.put("x-message-ttl", 60000);

        return QueueBuilder.durable(DELAY_QUEUEB).withArguments(maps).build();
    }

    // 声明死信队列A 用于接收延时10s处理的消息
    @Bean("deadLetterQueueA")
    public Queue deadLetterQueueA(){
        return new Queue(DEAD_LETTER_QUEUEA);
    }

    // 声明死信队列B 用于接收延时60s处理的消息
    @Bean("deadLetterQueueB")
    public Queue deadLetterQueueB(){
        return new Queue(DEAD_LETTER_QUEUEB);
    }

    // 将 队列A 绑定到延迟交换机上面
    @Bean
    public Binding delayBindingA(@Qualifier("delayQueueA") Queue queue,
                                 @Qualifier("delayExchange") DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(DELAY_QUEUEA_ROUTING_KEY);
    }

    // 将 队列B 绑定到延迟交换机上面
    @Bean
    public Binding delayBindingB(@Qualifier("delayQueueB") Queue queue,
                                 @Qualifier("delayExchange") DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(DELAY_QUEUEB_ROUTING_KEY);
    }

    // 将 死信队列A 绑定到死信交换机上
    @Bean
    public Binding deadLetterBindingA(@Qualifier("deadLetterQueueA") Queue queue,
                                      @Qualifier("deadLetterExchange") DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(DEAD_LETTER_QUEUEA_ROUTING_KEY);
    }

    // 将 死信队列B 绑定到死信交换机上
    @Bean
    public Binding deadLetterBindingB(@Qualifier("deadLetterQueueB") Queue queue,
                                      @Qualifier("deadLetterExchange") DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(DEAD_LETTER_QUEUEB_ROUTING_KEY);
    }

}
