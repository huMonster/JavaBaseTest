package com.base.reference;

import java.lang.ref.WeakReference;

/**
 * @Description 弱引用： 只要GC，一定回收
 * @Author Monster
 * @Date 2021/2/19 15:42
 * @Version 1.0
 */
public class WeakRefDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);

        System.out.println(o1 + "***********" + weakReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1 + "***********" + weakReference.get());
    }
}
