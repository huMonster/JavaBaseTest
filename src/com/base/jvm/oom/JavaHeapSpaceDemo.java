package com.base.jvm.oom;

/**
 * @Description OOM之堆空间异常
 * @Author Monster
 * @Date 2021/2/20 11:24
 * @Version 1.0
 */
public class JavaHeapSpaceDemo {
    /**
     * 1、指定JVM -Xms5m -Xmx5m
     * 2、创建一个6M的对象
     * 3、Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * @param args
     */
    public static void main(String[] args) {
        byte[] b = new byte[6 * 1024 *1024];
    }
}
