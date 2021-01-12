package com.zayan.www.config.timedtask;


import com.zayan.www.util.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务执行
 * @author AnYuan
 * @date 2021-01-12
 */

//@Component
public class TimeTaskTest {

    @Scheduled(fixedRate = 5000L)
    private void taskTest() {
        System.out.println("定时任务执行一次，时间：" + DateUtil.localDateTimeStr());
    }
}
