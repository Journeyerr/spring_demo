package com.zayan.www.service.thread.impl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadRunnable extends Thread{

    private static int count = 5;

    public ThreadRunnable() {

    }

    public ThreadRunnable(String name){
        super(name);
    }

    @Override
    public synchronized void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ", count: " + count--);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
