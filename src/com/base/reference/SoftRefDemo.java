package com.base.reference;

import java.lang.ref.SoftReference;

/**
 * @Description 软引用
 * @Author Monster
 * @Date 2021/2/19 14:19
 * @Version 1.0
 */
public class SoftRefDemo {

    /**
     * 内存足够，即使gc，也不会回收
     */
    public static void memory_enough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);

        System.out.println(o1 + "***********" + softReference.get());

        o1 = null;
        System.gc();

        // softReference.get()会将弱引用转为强引用
        System.out.println(o1 + "***********" + softReference.get());

    }

    /**
     * 内存不足，系统自动GC，软引用被回收
     * 产生一个6M的大对象，JVM的-Xms设置为5M
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void memory_not_enough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);

        System.out.println(o1 + "***********" + softReference.get());

        o1 = null;

        try {
            byte[] b = new byte[6 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1 + "***********" + softReference.get());
        }
    }

    public static void main(String[] args) {
//        memory_enough();

        memory_not_enough();
    }
}
