package com.base.string;

import java.util.concurrent.TimeUnit;

/**
 * @Description StringBuilder测试类
 * @Author Monster
 * @Date 2021/2/26 16:57
 * @Version 1.0
 */
public class StringBuilderDemo {

    public static void main(String[] args) throws InterruptedException {
        StringBuilder sbd = new StringBuilder(4000);
        testIsThreadSafe(sbd);
    }

    /**
     * 判断线程是否安全
     *
     * @param stringBuilder
     * @throws InterruptedException
     */
    public static void testIsThreadSafe(StringBuilder stringBuilder) throws InterruptedException {

        for (int i = 0; i < 40; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    stringBuilder.append(1);
                }
            }, i + "").start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(stringBuilder.length());
    }
}
