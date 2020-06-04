package com.zayan.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author AnYuan
 */

@SpringBootApplication
@MapperScan(basePackages = "com.zayan.www.repository")
public class ZayanApplication{

    public static void main(String[] args) {
        SpringApplication.run(ZayanApplication.class, args);
    }

}
