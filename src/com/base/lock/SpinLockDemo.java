package com.base.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description 自旋锁 好处：减少了锁上下文切换的开销、也没有类似await的阻塞
 *              通过CAS操作完成自旋锁，A线程先进来调用mylock方法持有5秒，B随后进来发现
 *              当前有线程持有锁，不为null，所以只能自选等待，指导A释放锁后B在持有
 * @Author Monster
 * @Date 2021/1/26 11:19
 * @Version 1.0
 */
public class SpinLockDemo {

    // 原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t come in");
        boolean flag = true;
        while(!atomicReference.compareAndSet(null, thread)){
            // 不需要打印多次
            if(flag){
                System.out.println("*******自旋中**********");
                flag = false;
            }
        }
    }
    public void myUnlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\t invoked myUnLock");
    }


    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() ->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        }, "AA").start();

        new Thread(() ->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        }, "BB").start();
    }
}
