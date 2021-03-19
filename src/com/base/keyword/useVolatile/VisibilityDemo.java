package com.base.keyword.useVolatile;

import java.util.concurrent.TimeUnit;
/**
 * @Description ValotileDemo 验证volatile可见性
 * @Author Monster
 * @Date 2021/1/14 14:22
 * @Version 1.0
 */
class MyData {

    volatile int number = 0;

    public void create() {
        this.number = 60;
    }
}
public class VisibilityDemo {
    public static void main(String[] args) {

        MyData myData = new MyData();

        /**
         * 证明：假如 int number = 0; number变量之前根本没有添加volatile关键字修饰，没有可见性
         * @param args
         */
        // 第一个线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.create();
            System.out.println(Thread.currentThread().getName() + "\t update number" + myData.number);
        }, "aaa").start();

        // 第二个线程就是main线程自己
        // 如果aaa线程操作的变量number对所有线程可见，那么此处的方法跳过
        // 否则一直卡在这
        while (myData.number == 0) {
            // main线程就一直循环等待，直到不等于0
        }
        System.out.println(Thread.currentThread().getName() + "" + "mission is over");
    }
}

