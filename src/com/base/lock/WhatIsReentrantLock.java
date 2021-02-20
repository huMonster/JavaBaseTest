package com.base.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 什么是可重入锁？就是可以重复获取相同的锁
 *              synchronized和ReentrantLock都是可重入的
 * @Author Monster
 * @Date 2021/1/26 10:00
 * @Version 1.0
 */
public class WhatIsReentrantLock {
    /**
     * 有点: 1、避免死锁
     *      2、低了编程复杂性
     * @param args
     */
    public static void main(String[] args) {
//        synchronizedMethod();
        reentrantLockMethod();

    }
    public static void synchronizedMethod(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    System.out.println("第1次获取锁，这个锁是：" + this);
                    int index = 1;
                    while (true) {
                        synchronized (this) {
                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + this);
                        }
                        if (index == 5) {
                            break;
                        }
                    }
                }
            }
        }).start();
    }
    public static void reentrantLockMethod(){
        ReentrantLock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("第1次获取锁，这个锁是：" + lock);

                    int index = 1;
                    while (true) {
                        try {
                            lock.lock();
                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + lock);
                            if (index == 5) {
                                break;
                            }
                        } finally {
                            lock.unlock();
                        }

                    }

                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
