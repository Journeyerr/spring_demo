package com.zayan.www.controller.test;

import com.zayan.www.model.entity.Skus;
import com.zayan.www.model.entity.User;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.AopTestService;
import com.zayan.www.service.SkusService;
import com.zayan.www.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author AnYuan
 */
@RestController
@Slf4j
@RequestMapping("/test/aop")
public class AopTestController {

    @Autowired
    private AopTestService aopTestService;

    @GetMapping("/print")
    public void print() {
        log.info("AopTestController_Start------");
        aopTestService.aopTestPrint();
    }
}
