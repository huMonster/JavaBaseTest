package com.base.string;

import java.util.concurrent.TimeUnit;

/**
 * @Description StringBuffer测试类
 * @Author Monster
 * @Date 2021/2/26 16:57
 * @Version 1.0
 */
public class StringBufferDemo {

    public static void main(String[] args) throws InterruptedException {
        StringBuffer sbf = new StringBuffer(4000);
        testIsThreadSafe(sbf);
    }

    /**
     * 判断线程是否安全
     *
     * @param stringBuffer
     * @throws InterruptedException
     */
    public static void testIsThreadSafe(StringBuffer stringBuffer) throws InterruptedException {

        for (int i = 0; i < 40; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    stringBuffer.append(1);
                }
            }, i + "").start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(stringBuffer.length());
    }
}
