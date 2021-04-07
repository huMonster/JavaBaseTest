package com.base.singleton;

/**
 * @Description 静态内部类：线程安全，效率高
 * @Author Monster
 * @Date 2020/12/25 15:38
 * @Version 1.0
 */
public class SingletonInnerClass {
    private SingletonInnerClass() {
        System.out.println("被创建！！！");
    }

    /**
     * 在内部类被加载和初始化时才创建 INSTANCE 实例对象
     */
    private static class InstanceHolder{
        // 使用final修饰
        final static SingletonInnerClass instance = new SingletonInnerClass();
    }

    public SingletonInnerClass getInstance(){
        return InstanceHolder.instance;
    }
}
