package com.base.singleton;

/**
 * @Description 枚举
 * @Author Monster
 * @Date 2020/12/25 15:07
 * @Version 1.0
 */
public enum SingletonEnum {
    /**
     * 枚举（effective Java书中 P15说：单元素的枚举类型经常成为实现单例的最佳方法）
     * 优点：线程安全、用到时再加载、避免反序列化、避免反射、避免克隆
     *
     */
    INSTANCE;
}
