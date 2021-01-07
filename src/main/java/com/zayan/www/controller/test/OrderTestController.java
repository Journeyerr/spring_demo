package com.zayan.www.controller.test;

import com.zayan.www.service.AopTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AnYuan
 */
@RestController
@Slf4j
@RequestMapping("/test/order")
public class OrderTestController {

    @Autowired
    private AopTestService aopTestService;

    @GetMapping("/print")
    public void print() {
        log.info("AopTestController_End------");
        aopTestService.aopTestPrint();
    }
}
