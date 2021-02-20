package com.base.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description 信号量 举例：争车位  (可加可减，具有伸缩性）
 *              限流、做支付接口
 *              两个作用： 一、多个共享资源的互斥使用; 二、控制线程并发数
 * @Author Monster
 * @Date 2021/1/26 17:19
 * @Version 1.0
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 获取许可，即模拟3个车位，默认下是非公平锁
        Semaphore semaphore = new Semaphore(3);
//        Semaphore semaphore = new Semaphore(3, true);
        // 模拟6辆车
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    // 抢占车位
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "\t 停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 需要释放
                    semaphore.release();
                }

            }, String.valueOf(i)).start();
        }
    }
}
