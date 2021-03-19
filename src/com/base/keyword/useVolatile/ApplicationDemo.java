package com.base.keyword.useVolatile;

/**
 * @Description volatile在单例模式的应用场景
 * @Author Monster
 * @Date 2021/1/14 17:50
 * @Version 1.0
 */
public class ApplicationDemo {
    private static volatile ApplicationDemo instance = null;

    private ApplicationDemo(){
        System.out.println("ApplicationDemo被创建了一次！");
    }

    /**
     * 1、在方法上加synchronized
     * 但是量级太重，影响并发的性能
     * 2、使用DCL（double check lock双端检锁机制）
     * 但是由于指令重排序的机制，所以还是有非常小的几率出现多次创建
     * 原因： memory = new ApplicationDemo() //1. 分配对象内存空间
     *        instance(memory);             //2. 初始化对象
     *        instance = memory;            //3. 将instance指向刚分配的内存地址，此时instance != null
     *        （张三 老师 位置 同学看  名副其实）
     *       步骤2和3不存在数据依赖关系，可能会指令重排，
     *       当线程A创建instance,但还没有初始化完成，此时instance != null（名不副实），
     *       在<语句1>判断为false,则直接return instance;
     *       当线程B创建时，拿到instance == null，进入方法后重新创建instance，则线程A和线程B将会创建两个实例对象
     *
     * 3、解决：DCL + volatile
     */
    public static ApplicationDemo getInstance(){
        if(instance == null){ // 语句1
            synchronized (ApplicationDemo.class){
                if(instance == null){
                    instance = new ApplicationDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        // 单线程下
//        System.out.println(ApplicationDemo.getInstance() == ApplicationDemo.getInstance());
//        System.out.println(ApplicationDemo.getInstance() == ApplicationDemo.getInstance());
//        System.out.println(ApplicationDemo.getInstance() == ApplicationDemo.getInstance());

        // 多线程下创建了多次
        /** result
         * ApplicationDemo被创建了一次！
         * ApplicationDemo被创建了一次！
         * ApplicationDemo被创建了一次！
         * ApplicationDemo被创建了一次！
         * ApplicationDemo被创建了一次！
         */
        for (int i = 0; i < 10000; i++) {
            new Thread(ApplicationDemo::getInstance).start();
            new Thread(ApplicationDemo::getInstance).start();
            new Thread(ApplicationDemo::getInstance).start();
            new Thread(ApplicationDemo::getInstance).start();
        }
    }
}
