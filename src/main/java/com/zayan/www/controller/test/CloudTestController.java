package com.zayan.www.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/cloud")
public class CloudTestController {

    @GetMapping("")
    public String testCloud() {
        return "User-Server: TestCloud Feign";
    }
}
