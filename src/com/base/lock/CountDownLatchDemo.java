package com.base.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @Description 火箭发射倒计时（减法）  举例：秦灭六国，才能统一
 * @Author Monster
 * @Date 2021/1/26 15:48
 * @Version 1.0
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        // 指定计数器数量
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国，被灭！");
                // 计数器减1
                countDownLatch.countDown();
            }, CountryEnum.Foreach_CountryEnum(i).getRetMessage()).start();
        }
        // 等待计数器为0后执行下面代码
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "秦灭六国，大统一！");

    }
}
