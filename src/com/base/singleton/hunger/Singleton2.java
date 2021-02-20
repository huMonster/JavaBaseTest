package com.base.singleton.hunger;

/**
 * @Description Singleton1
 * @Author Monster
 * @Date 2020/12/25 15:07
 * @Version 1.0
 */

/**
 * 饿汉三式： 枚举
 */
public enum  Singleton2 {
    INSTANCE;

    public static Singleton2 getInstance(){
        return INSTANCE;
    }
}
