package com.zayan.www.service.thread.impl;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadRunnable extends Thread{

    public ThreadRunnable() {

    }

    public ThreadRunnable(String name){
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
