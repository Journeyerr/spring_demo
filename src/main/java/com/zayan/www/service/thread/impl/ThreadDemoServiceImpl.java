package com.zayan.www.service.thread.impl;

import com.zayan.www.service.thread.ThreadDemoService;
import org.springframework.stereotype.Service;

@Service
public class ThreadDemoServiceImpl implements ThreadDemoService {

    @Override
    public void printHelloWorld() {
        ThreadRunnable runnable = new ThreadRunnable();
        runnable.start();
    }

    @Override
    public void forPrintHelloWorld() {
        Thread[] threads = new Thread[10];
        for (int i = 0; i<10; i++){
            threads[i] = new ThreadRunnable("ThreadRunnable:" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
