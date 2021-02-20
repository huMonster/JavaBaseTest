package com.base.singleton.lazy;

/**
 * @Description Singleton1
 * @Author Monster
 * @Date 2020/12/25 15:38
 * @Version 1.0
 */
/**
 * 懒汉三式： 延迟占位类模式（线程安全、优雅简洁，但会被反射修改）
 * 静态内部类不会自动随着外部类的加载和初始化而初始化，要单独调用才会初始化
 */
public class Singleton3 {

    private Singleton3() {
        System.out.println("被创建！！！");
    }

    /**
     * 在内部类被加载和初始化时才创建 INSTANCE 实例对象
     */
    private static class InstanceHolder{
        private static Singleton3 instance = new Singleton3();
    }

    public Singleton3 getInstance(){
        return InstanceHolder.instance;
    }
}
