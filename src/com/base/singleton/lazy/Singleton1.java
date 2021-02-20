package com.base.singleton.lazy;

/**
 * @Description Singleton1
 * @Author Monster
 * @Date 2020/12/25 15:38
 * @Version 1.0
 */
/**
 * 懒汉三式： 延迟创建实例（线程不安全）
 *
 * 步骤：
 *      1、私有构造器
 *      2、私有静态变量保存实例
 *      3、提供一个静态方法，获取该实例，对外使用
 */
public class Singleton1 {

    private static Singleton1 instance;

    private Singleton1() {
    }

    public static Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
}
