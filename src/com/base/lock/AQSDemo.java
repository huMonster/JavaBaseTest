package com.base.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description AQSDemo
 * @Author Monster
 * @Date 2021/1/4 9:35
 * @Version 1.0
 */
public class AQSDemo {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }
}
