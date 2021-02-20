package com.base.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @Description PhantomRefDemo
 * @Author Monster
 * @Date 2021/2/19 16:23
 * @Version 1.0
 */
public class PhantomRefDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference<Object> reference = new PhantomReference<>(o1, referenceQueue);

        System.out.println(o1 + "************" + reference.get() + "*************" + referenceQueue.poll());
        System.out.println("-----------------------------");
        o1 = null;
        System.gc();
        Thread.sleep(500);

        System.out.println(o1 + "************" + reference.get() + "*************" + referenceQueue.poll());
    }
}
