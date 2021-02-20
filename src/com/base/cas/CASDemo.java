package com.base.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description CASDemo CAS 自旋锁
 * @Author Monster
 * @Date 2021/1/20 17:32
 * @Version 1.0
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();

        boolean b = atomicInteger.compareAndSet(0, 1);
        boolean b1 = atomicInteger.compareAndSet(0, 2);
        System.out.println("is updated? " + b +";  atomic: " + atomicInteger.get());
        System.out.println("is updated? " + b1 +";  atomic: " + atomicInteger.get());
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get());
    }
}
