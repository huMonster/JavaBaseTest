package com.base.jvm.gc;

import java.util.Random;

/**
 * @Description 垃圾回收器测试
 * @Author Monster
 * @Date 2021/2/22 16:50
 * @Version 1.0
 */
public class GCDemo {
    /**
     * JVM参数：
     * 新生代：
     *   1、-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC  (DefNew + Tenured)
     *   2、-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC  (ParNew + Tenured)
     *     Java HotSpot(TM) 64-Bit Server VM warning: Using the ParNew young collector with the Serial old collector
     *     is deprecated and will likely be removed in a future release
     *   3、-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC  (PSYoungGen + ParOldGen)
     * 老年代：
     *   4、-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC  (PSYoungGen + ParOldGen)
     *   5、-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC  (ParNew + CMS)
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println("GCDemo 开始*************");
        try {
            String str = "GCDemo";
            while (true){
                str += str + new Random().nextInt(77777777) + new Random().nextInt(88888888);
                str.intern();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
