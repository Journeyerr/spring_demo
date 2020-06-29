package com.zayan.www.service.thread.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zayan.www.model.entity.Skus;
import com.zayan.www.service.SkusService;
import com.zayan.www.service.thread.ThreadDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class ThreadDemoServiceImpl implements ThreadDemoService {

    @Autowired
    private SkusService skusService;

    @Override
    public void printHelloWorld() {
        new Thread(()->System.out.println("多线程任务执行！")).start();
    }

    @Override
    public void forPrintHelloWorld() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> updateSku(Thread.currentThread().getName()));
        }
        //关闭启动线程
        executor.shutdown();
        //子线程是否全部结束
        boolean terminated = executor.isTerminated();
    }

    public synchronized void updateSku(String treadName){
        log.info("updateSku------->run:" + treadName);

        Skus sku = skusService.getById(1);
        log.info("byId---->{}", sku);

        Integer version = sku.getVersion();
        sku.setStock(sku.getStock()-1);

        boolean update = skusService.update(sku, new UpdateWrapper<Skus>().lambda().eq(Skus::getId, sku.getId()).eq(Skus::getVersion, version));
        log.info("update-result:{}", update);
    }
}
