package com.base.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description Condition -> await暂停线程,signal唤醒线程
 * @Author Monster
 * @Date 2020/12/31 17:04
 * @Version 1.0
 */
public class ConditionAwaitAndSignalTest {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "------come in");
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "------被唤醒");
            } finally {
                lock.unlock();
            }
        }, "A").start();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "------通知");
                condition.signal();
            } finally {
                lock.unlock();
            }
        }, "B").start();
    }
}
