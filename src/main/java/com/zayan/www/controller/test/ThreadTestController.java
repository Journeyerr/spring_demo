package com.zayan.www.controller.test;

import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.thread.ThreadDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("thread/")
@Slf4j
public class ThreadTestController {

    @Autowired
    private ThreadDemoService threadDemoService;

    @GetMapping("/")
    public BaseResult<?> printHelloWorld() {
        threadDemoService.printHelloWorld();
        return BaseResult.success();
    }

    @GetMapping("/for")
    public BaseResult<?> forPrintHelloWorld() {
        threadDemoService.forPrintHelloWorld();
        return BaseResult.success();
    }

    @GetMapping("test/update")
    public BaseResult<?> testUpdate() {
        return BaseResult.success();
    }
}
