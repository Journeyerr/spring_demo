package com.zayan.www;


import com.zayan.www.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import sun.jvm.hotspot.utilities.WorkerThread;

import java.util.concurrent.*;

@SpringBootTest
public class ThreadTest {

    /**
     * newFixedThreadPool
     *
     * 线程池特点：
     * 核心线程数和最大线程数大小一样
     * 没有所谓的非空闲时间，即keepAliveTime为0
     * 阻塞队列为无界队列LinkedBlockingQueue
     *
     * 工作机制：
     * 提交任务
     * 如果线程数少于核心线程，创建核心线程执行任务
     * 如果线程数等于核心线程，把任务添加到LinkedBlockingQueue阻塞队列
     * 如果线程执行完任务，去阻塞队列取任务，继续执行。
     *
     * 使用场景
     * 适用执行长期的任务
     */

    @Test
    public void fixedThreadPoolTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> System.out.println("Hello World:" + Thread.currentThread().getName()));
        }

    }


    /**
     * newCachedThreadPool
     *
     * 线程池特点：
     * 核心线程数为0
     * 最大线程数为Integer.MAX_VALUE
     * 阻塞队列是SynchronousQueue
     * 非核心线程空闲存活时间为60秒
     *
     * 工作机制：
     * 提交任务
     * 因为没有核心线程，所以任务直接加到SynchronousQueue队列。
     * 判断是否有空闲线程，如果有，就去取出任务执行。
     * 如果没有空闲线程，就新建一个线程执行。
     * 执行完任务的线程，还可以存活60秒，如果在这期间，接到任务，可以继续活下去；否则，被销毁。
     *
     * 使用场景
     * 用于并发执行大量短期的小任务。
     */
    @Test
    public void cachedThreadTest() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> System.out.println("Hello World:" + Thread.currentThread().getName()));
        }
    }

    /**
     * 线程池特点
     * 核心线程数为1
     * 最大线程数也为1
     * 阻塞队列是LinkedBlockingQueue
     * keepAliveTime为0
     *
     *工作机制：
     * 提交任务
     * 线程池是否有一条线程在，如果没有，新建线程执行任务
     * 如果有，讲任务加到阻塞队列
     * 当前的唯一线程，从队列取任务，执行完一个，再继续取，一个人（一条线程）夜以继日地干活。
     *
     * 使用场景：
     * 适用于串行执行任务的场景，一个任务一个任务地执行。
     */
    @Test
    public void singleThreadTest() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> System.out.println("Hello World:" + Thread.currentThread().getName()));
        }
    }

    /**
     * 线程池特点
     *
     * 最大线程数为Integer.MAX_VALUE
     * 阻塞队列是DelayedWorkQueue
     * keepAliveTime为0
     * scheduleAtFixedRate() ：按某种速率周期执行
     * scheduleWithFixedDelay()：在某个延迟后执行
     *
     *
     * 工作机制：
     * 添加一个任务
     * 线程池中的线程从 DelayQueue 中取任务
     * 线程从 DelayQueue 中获取 time 大于等于当前时间的task
     * 执行完后修改这个 task 的 time 为下次被执行的时间
     * 这个 task 放回DelayQueue队列中
     */


    @Test
    public void scheduledThreadTest() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleWithFixedDelay(()->{
            System.out.println("current Time" + System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName()+"正在执行");
        }, 1, 3, TimeUnit.SECONDS);

    }

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        // 定时调度，每个调度任务会至少等待`period`的时间，
        // 如果任务执行的时间超过`period`，则等待的时间为任务执行的时间
        executor.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("当前线程：" + Thread.currentThread().getName());
                System.out.println(DateUtil.nowDateTimeString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 3, TimeUnit.SECONDS);

        // 定时调度，第二个任务执行的时间 = 第一个任务执行时间 + `delay`
        executor.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("当前线程：scheduleWithFixedDelay:" + Thread.currentThread().getName());
                System.out.println(DateUtil.nowDateTimeString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, 0, 3, TimeUnit.SECONDS);

        // 定时调度，延迟`delay`后执行，且只执行一次
        executor.schedule(() -> System.out.println("5 秒之后执行 schedule"), 5, TimeUnit.SECONDS);
    }
}
