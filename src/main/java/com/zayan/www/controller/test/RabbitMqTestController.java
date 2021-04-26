package com.zayan.www.controller.test;

import com.google.common.collect.Maps;
import com.zayan.www.constant.RabbitMqConstant;
import com.zayan.www.rabbitmq.config.DelayQueueConfig;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.RabbitMqService;
import com.zayan.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/test/mq/")
public class RabbitMqTestController {

    @Autowired
    private RabbitMqService rabbitMqService;

    @Autowired
    private UserService userService;


    @GetMapping("send")
    public BaseResult<?> sendMq() {
        rabbitMqService.send(RabbitMqConstant.USER_EXCHANGE, "", userService.getById(1));
        return BaseResult.success();
    }

    @GetMapping("/send/delay")
    public BaseResult<?> sendDelayMsg(@RequestParam("msg") String msg) {

        Map<String, Object> msgMap = Maps.newHashMapWithExpectedSize(2);
        msgMap.put("msg", msg);
        msgMap.put("date", LocalDateTime.now());
        rabbitMqService.send(DelayQueueConfig.DELAY_EXCHANGE, DelayQueueConfig.DELAY_QUEUE_ROUTING_KEY, msgMap);
        return BaseResult.success();
    }


    @GetMapping("/send/delay/ttl")
    public BaseResult<?> sendDelayTtlMsg(@RequestParam("msg") String msg, @RequestParam("ttl") Integer ttl) {

        Map<String, Object> msgMap = Maps.newHashMapWithExpectedSize(3);
        msgMap.put("msg", msg);
        msgMap.put("date", LocalDateTime.now());
        msgMap.put("ttl", ttl);
        rabbitMqService.ttlSend(DelayQueueConfig.DELAY_EXCHANGE, DelayQueueConfig.DELAY_QUEUE_ROUTING_KEY, msgMap, ttl);
        return BaseResult.success();
    }
}
