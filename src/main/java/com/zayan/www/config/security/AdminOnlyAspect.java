package com.zayan.www.config.security;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdminOnlyAspect {

    @Pointcut("@annotation(AdminOnly)")
    private void adminOnlyCheck() {

    }

    @Before("adminOnlyCheck()")
    private void beforePrint() {
        System.out.println("Aspect --  Before -- -- beforePrint");
    }

    @After("adminOnlyCheck()")
    private void afterPrint() {
        System.out.println("Aspect --  Before -- -- afterPrint");
    }

}
