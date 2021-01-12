package com.zayan.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author AnYuan
 */

//@EnableEurekaClient
//@EnableFeignClients
@EnableScheduling
@MapperScan(basePackages = "com.zayan.www.repository")
@SpringBootApplication
public class ZayanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZayanApplication.class, args);
    }

}
