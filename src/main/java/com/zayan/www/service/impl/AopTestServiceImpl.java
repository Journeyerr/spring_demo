package com.zayan.www.service.impl;

import com.zayan.www.config.security.AdminOnly;
import com.zayan.www.service.AopTestService;
import org.springframework.stereotype.Service;

@Service
public class AopTestServiceImpl implements AopTestService {


    @Override
    @AdminOnly
    public void aopTestPrint() {
        System.out.println("AopTestServiceImpl --- aopTestPrint");
    }

    @Override
    public void aopTestMethodsPrint() {
        System.out.println("AopTestServiceImpl ----- aopTestMethodsPrint");
    }
}
