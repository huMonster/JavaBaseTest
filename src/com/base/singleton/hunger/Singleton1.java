package com.base.singleton.hunger;

/**
 * @Description Singleton1
 * @Author Monster
 * @Date 2020/12/25 15:07
 * @Version 1.0
 */

/**
 * 饿汉三式： 直接创建实例
 *
 * 步骤：
 *      1、私有构造器
 *      2、静态变量保存实例
 *      3、向外提供该实例
 *      4、强调这是一个单例，可以使用final修饰
 */
public class Singleton1 {
//    public static Singleton1 instance = new Singleton1();
    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }
}
