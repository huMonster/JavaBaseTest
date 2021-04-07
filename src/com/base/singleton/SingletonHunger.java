package com.base.singleton;

/**
 * @Description 饿汉单例（直接创建实例）
 * @Author Monster
 * @Date 2020/12/25 15:07
 * @Version 1.0
 */
public class SingletonHunger {
    /**
     * 步骤：
     *      1、私有构造器
     *      2、静态变量保存实例
     *      3、向外提供该实例
     *      4、强调这是一个单例，可以使用final修饰
     */
    public static final SingletonHunger INSTANCE = new SingletonHunger();

    public String name = "私有name";

    private SingletonHunger() {
        System.out.println("饿汉单例被创建");
    }
}
