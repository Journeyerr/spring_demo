package com.zayan.www.controller.test;

import com.google.common.collect.Maps;
import com.zayan.www.config.rabbitMq.DelayQueueConfig;
import com.zayan.www.constant.enums.RabbitMqMessageConstant;
import com.zayan.www.model.entity.User;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.rabbitmq.publisher.RabbitMqService;
import com.zayan.www.service.UserService;
import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mq/test/")
public class RabbitMqTestController {

    private static final Integer TYPE_TEN = 10;
    private static final Integer TYPE_SIXTY = 60;

    @Autowired
    private RabbitMqService<Object> rabbitMqService;

    @Autowired
    private UserService userService;


    @GetMapping("send")
    public BaseResult<?> sendMq() {
        rabbitMqService.send(RabbitMqMessageConstant.USER_EXCHANGE, "", userService.getById(1));
        return BaseResult.success();
    }

    @GetMapping("/send/delay")
    public BaseResult<?> sendDelayMsg(@RequestParam("type") Integer type, @RequestParam("msg") String msg) {

        Map<String, Object> msgMap = Maps.newHashMapWithExpectedSize(2);
        msgMap.put("type", type);
        msgMap.put("msg", msg);
        msgMap.put("date", LocalDateTime.now());

        String routingKey;

        if (TYPE_TEN.equals(type)) {
            routingKey = DelayQueueConfig.DELAY_QUEUEA_ROUTING_KEY;
        }else if (TYPE_SIXTY.equals(type)) {
            routingKey = DelayQueueConfig.DELAY_QUEUEB_ROUTING_KEY;
        }else {
            return BaseResult.error("type error");
        }
        rabbitMqService.send(DelayQueueConfig.DELAY_EXCHANGE, routingKey, msgMap);
        return BaseResult.success();
    }
}
