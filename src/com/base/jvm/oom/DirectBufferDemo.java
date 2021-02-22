package com.base.jvm.oom;

import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;

/**
 * @Description OOM之Direct buffer memory
 * @Author Monster
 * @Date 2021/2/20 14:30
 * @Version 1.0
 */
public class DirectBufferDemo {
    /**
     * 参数配置：
     * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
     *
     * 故障现象：
     * Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
     *
     * 导致原因：
     * 写NIO的程序经常使用ByteBuffer来读取或者写入数据，这是一种基于通道（Channel）和缓冲区（Buffer）的I/O方式，
     * 它使用Native函数库直接分配堆外内存，然后通过一个存储在Java堆中的DirectByteBuffer对象作为这块内存的引用进行操作
     * 这样能在一些场景中显著提高性能，因为避免了Java堆和Native堆中来回复制数据。
     * ByteBuffer.allocate(capacity) 第一种方式是分配JVM堆内存，属于GC管辖范围，由于需要拷贝所以速度相对较慢
     * ByteBuffer.allocateDirect(capacity) 第二种方式是分配OS本地内存，不属于GC管辖的范畴，由于不需要内存拷贝，所以速度相对较快
     */
    public static void main(String[] args) {

        System.out.println(sun.misc.VM.maxDirectMemory() / 1024 / 1024);

        ByteBuffer buffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
