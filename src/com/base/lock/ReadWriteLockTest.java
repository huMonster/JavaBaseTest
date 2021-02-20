package com.base.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description 读写锁验证: 不加锁前和加锁后对比
 * @Author Monster
 * @Date 2021/1/26 14:52
 * @Version 1.0
 */

class MyCache{
    // 做缓存的都要使用volatile修饰
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    // 原子操作 + 独占锁
    public void put(String key, Object value){
        try {
            rwLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "\t 正在写入： " + key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成： ");
        } finally {
            rwLock.writeLock().unlock();
        }
    }
    // 共享锁
    public void get(String key){
        try {
            rwLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "\t 正在读取： " + key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成： "+  result);
        } finally {
            rwLock.readLock().unlock();
        }
    }
}
public class ReadWriteLockTest{
    /**
     * 读读不互斥 读写互斥 写写互斥
     *
     * @param args
     */
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt);
            }, String.valueOf(i)).start();
        }
        for (int i = 0; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }
}
