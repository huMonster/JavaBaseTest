package com.base.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description OOM之GC overhead limit exceeded
 * @Author Monster
 * @Date 2021/2/20 13:57
 * @Version 1.0
 */
public class GCOverheadLimitDemo {
    /**
     * java.lang.OutOfMemoryError: GC overhead limit exceeded
     * GC回收时间过长会抛出OOM
     * Oracle官网对过长的定义是，超过98%的时间来做GC并且恢复了不到2%的堆内存
     * 这意味着我们的应用程序几乎耗尽了所有可用内存，垃圾收集器花了太长时间试图清理它，并多次失败
     *
     * 测试： 1、设置JVM参数
     *             -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while(true){
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("**************************" + i);
            e.printStackTrace();
        }
    }
}
