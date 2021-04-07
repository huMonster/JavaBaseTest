package com.base.singleton;

/**
 * @Description 懒汉单例： 双检锁机制 + volatile
 * @Author Monster
 * @Date 2020/12/25 15:38
 * @Version 1.0
 */
public class SingletonLazy {
    /**
     * 优点：即用即创建，用到时再创建
     * 缺点：太繁杂，代码不够优雅，效率一般
     *
     */
    private volatile static SingletonLazy INSTANCE = null;

    private SingletonLazy(){}

    public static SingletonLazy getInstance(){
        // 优化，一旦有人获得，就不需要再进入锁去判断
        if(INSTANCE == null){
            synchronized (SingletonLazy.class){
                if(INSTANCE == null){
                    INSTANCE = new SingletonLazy();
                }
            }
        }
        return INSTANCE;
    }
}
