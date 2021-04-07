package com.base.singleton;

import java.lang.reflect.Constructor;

/**
 * @Description 反序列化、克隆、反射测试单例
 * @Author Monster
 * @Date 2021/4/7 22:18
 * @Version 1.0
 */
public class SingletonTest {

    /**
     * 反射破坏饿汉式: 成功
     * 反射破坏懒汉式：失败 Exception in thread "main" java.lang.reflect.InvocationTargetException
     */
    public static void reflect() throws Exception {
        Class<?> c1 = Class.forName("com.base.singleton.SingletonLazy");
        Class<?> c2 = Class.forName("com.base.singleton.SingletonHunger");
        Class<?> c3 = Class.forName("com.base.singleton.SingletonInnerClass");
        Class<?> c4 = Class.forName("com.base.singleton.SingletonHunger");
        Constructor<?> declaredConstructor = c3.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        // 饿汉输出测试
        SingletonHunger h1 = SingletonHunger.INSTANCE;
        SingletonHunger h2 = SingletonHunger.INSTANCE;
        SingletonHunger h3 = (SingletonHunger) declaredConstructor.newInstance();
        System.out.println(h1.equals(h2));
        System.out.println(h1.equals(h3));
        // 懒汉输出测试


    }
    public static void main(String[] args) throws Exception {
        reflect();
    }
}
