package com.base.jmm.useVolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description ValotileDemo 验证volatile可见性
 * @Author Monster
 * @Date 2021/1/14 14:22
 * @Version 1.0
 */
class TestData {

    // volatile不保证原子性
    volatile int number = 0;
    // 使用原子类保证原子性（底层CAS）
    AtomicInteger atomicInteger = new AtomicInteger();

    public void add() {
        this.number++;
    }

    public void addAtom() {
        atomicInteger.getAndIncrement();
    }
}

public class AtomicityDemo {
    public static void main(String[] args) {

        TestData myData = new TestData();
        /**
         * volatile 不保证原子性
         */
        // 10个线程，每个线程执行100次add()操作
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    myData.add();
                    // 解决验证
                    myData.addAtom();
                }
            }, "aaa").start();

        }
        System.out.println("预期值为1000，实际number=" + myData.number);
        System.out.println("预期值为1000，实际atomicInteger=" + myData.atomicInteger);
    }
}

