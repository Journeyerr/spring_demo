package com.zayan.www.service;

import org.springframework.stereotype.Service;

@Service
public interface AopTestService {

    void aopTestPrint();

    void aopTestMethodsPrint();

    void aopTestMethodsPrintJoin(String printInfo);
}
