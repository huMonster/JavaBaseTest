package com.base.lock;

/**
 * synchronized用法测试
 *
 *   该关键字是在软件层面通过jvm实现的
 */
public class SynchronizedTest implements Runnable{

    public static SynchronizedTest instance = new SynchronizedTest();
    public static int i = 0;

    @Override
    public void run() {
        // 两种方式都可以
        // synchronized (SynchronizedTest.class){
        synchronized (instance){
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new SynchronizedTest());
        Thread t2 = new Thread(new SynchronizedTest());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
