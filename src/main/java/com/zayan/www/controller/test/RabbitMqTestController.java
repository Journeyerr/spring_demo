package com.zayan.www.controller.test;

import com.zayan.www.constant.enums.RabbitMqMessageConstant;
import com.zayan.www.model.entity.User;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.rabbitmq.publisher.RabbitMqService;
import com.zayan.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq/test/")
public class RabbitMqTestController {

    @Autowired
    private RabbitMqService<User> rabbitMqService;

    @Autowired
    private UserService userService;


    @GetMapping("send")
    public BaseResult<?> sendMq() {
        rabbitMqService.send(RabbitMqMessageConstant.USER_EXCHANGE, "", userService.getById(1));
        return BaseResult.success();
    }
}
