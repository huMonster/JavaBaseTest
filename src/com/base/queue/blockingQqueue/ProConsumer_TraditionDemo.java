package com.base.queue.blockingQqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
class ShareData {
    private int num = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            // 1、判断，多线程判断使用while（官网也有说明），用if会出错！
//            if (num != 0) {
            while (num != 0) {
                // 等待中
                condition.await();
            }
            // 2、干活
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            // 3、通知唤醒消费者
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            // 1、判断
            while(num != 1){
                condition.await();
            }

            // 2、干活
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + num);

            // 3、通知生产者
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
}

/**
 * @Description 生产消费者-传统版本
 * @Author Monster
 * @Date 2021/1/27 14:30
 * @Version 1.0
 */
public class ProConsumer_TraditionDemo {
    /**
     * 要求： 初始值为0的变量，两个线程对其交替操作，一个叫一一个减一，来五轮
     * <p>
     * 1、线程 操作(方法) 资源类（所以一定要有一个资源类，资源类里有相应的操作方法，符合高内聚）
     * 2、判断 干活 通知
     * 3、防止虚假唤醒机制
     *
     * @param args
     */
    public static void main(String[] args) {

        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                shareData.increment();
            }
        }, "AAA").start();
        new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                shareData.increment();
            }
        }, "CCC").start();

        new Thread(()->{
            for (int i = 1; i <=5; i++) {
                shareData.decrement();
            }
        }, "BBB").start();
        new Thread(()->{
            for (int i = 1; i <=5; i++) {
                shareData.decrement();
            }
        }, "DDD").start();
    }

}
