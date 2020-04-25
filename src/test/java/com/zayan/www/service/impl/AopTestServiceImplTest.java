package com.zayan.www.service.impl;

import com.zayan.www.service.AopTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AopTestServiceImplTest {

    @Autowired
    private AopTestService aopTestService;

    @Test
    public void aopTest(){
        aopTestService.aopTestPrint();
    }

    @Test
    public void aopTestPrint(){
        aopTestService.aopTestMethodsPrint();
    }

}