package com.base.singleton.lazy;

/**
 * @Description Singleton1
 * @Author Monster
 * @Date 2020/12/25 15:38
 * @Version 1.0
 */
/**
 * 懒汉三式： 延迟创建实例（线程安全）
 * 缺点：太繁杂，代码不够优雅
 *
 * 步骤：
 *      1、私有构造器
 *      2、静态变量保存实例
 *      3、提供一个静态方法，获取该实例，对外使用
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2(){}

    public static Singleton2 getInstance(){
        // 优化，一旦有人获得，就不需要再进入锁去判断
        if(instance == null){
            synchronized (Singleton2.class){
                if(instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
