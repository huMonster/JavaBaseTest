package com.base.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description JUC新的线程控制 park挂起/unPark唤醒
 * @Author Monster
 * @Date 2020/12/31 17:33
 * @Version 1.0
 */
public class LockSupportTest {

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "---------come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "-----------被唤醒");
        }, "A");
        a.start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "-------------通知");
            LockSupport.unpark(a);
        }, "B").start();
    }
}
