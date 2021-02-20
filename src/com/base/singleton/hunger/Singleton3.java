package com.base.singleton.hunger;

/**
 * @Description Singleton1
 * @Author Monster
 * @Date 2020/12/25 15:07
 * @Version 1.0
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 饿汉三式： 直接创建实例
 *
 * 步骤：
 *      1、私有构造器
 *      2、静态变量保存实例
 *      3、提供一个静态方法，获取该实例，对外使用
 */
public class Singleton3 {

    public static final Singleton3 INSTANCE;

    private Singleton3() {
    }

    static {
        INSTANCE = new Singleton3();
    }

}
