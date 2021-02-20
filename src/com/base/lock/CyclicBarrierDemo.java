package com.base.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description 可循环使用的屏障（加法） 举例：集齐七龙珠，召唤神龙
 * @Author Monster
 * @Date 2021/1/26 16:19
 * @Version 1.0
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () ->{
            System.out.println("********龙珠集齐，召唤神龙！");
        });
        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                System.out.println("收集到" + Thread.currentThread().getName() + "星龙珠");
                try {
                    // 先到先阻塞，等到齐了，在开始执行
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
