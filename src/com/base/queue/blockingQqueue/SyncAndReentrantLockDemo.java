package com.base.queue.blockingQqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 多线程之间按顺序调用，实现A -> B -> C三个线程启动，要求如下：
 *              AA打印5次， BB打印10次， CC打印15次
 *              紧接着
 *              AA打印5次.....
 *              依次执行10轮
 * @Author Monster
 * @Date 2021/1/27 16:00
 * @Version 1.0
 */
class ShareResource{

    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    // A = 1 B = 2 C = 3
    private int num = 1;

    public void print5(){
        lock.lock();
        try {
            //1、判断
            while (num != 1){
                c1.await();
            }
            //2、干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3、通知
            num = 2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try {
            //1、判断
            while (num != 2){
                c2.await();
            }
            //2、干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3、通知
            num = 3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try {
            //1、判断
            while (num != 3){
                c3.await();
            }
            //2、干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3、通知
            num = 1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {

        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print5();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print15();
            }
        },"C").start();
    }
}
