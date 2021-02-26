package com.base.string;

import java.util.Random;

/**
 * @Description 检验JDK8中[字符串常量池]存放在堆中还是方法区？
 * @Author Monster
 * @Date 2021/2/26 11:14
 * @Version 1.0
 */
public class StringConstantPool {
    public static void main(String[] args) {

        /**
         * 设置JVM参数： -Xms12m -Xmx12m -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
         * 运行结果为：Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
         */
        String a = "abcdefg";
        for (int i = 0; i < 20; i++) {
            a += a + new Random(77777777).nextInt(88888888);
        }
    }
}
