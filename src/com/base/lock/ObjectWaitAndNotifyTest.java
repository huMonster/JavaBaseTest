package com.base.lock;

import java.util.concurrent.TimeUnit;

/**
 * @Description Object wait/notify
 * @Author Monster
 * @Date 2020/12/31 15:27
 * @Version 1.0
 */
public class ObjectWaitAndNotifyTest {

    static Object objectLock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objectLock){
                System.out.println(Thread.currentThread().getName() + "come in");
                try {
                    // 挂机线程
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "被唤醒");
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (objectLock){
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "唤醒程序");
            }
        }, "B").start();
    }

}
