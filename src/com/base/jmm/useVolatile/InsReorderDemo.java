package com.base.jmm.useVolatile;

/**
 * @Description volatile禁止指令重排
 * @Author Monster
 * @Date 2021/1/14 17:22
 * @Version 1.0
 */
public class InsReorderDemo {
    volatile int i = 0;
    boolean flag = false;

    /**
     * 多线程环境中线程交替执行， 有可能线程A的语句2先执行，然后线程2执行了语句3,
     */
    public void method1() {
        this.i = 1;  // 语句1
        flag = true; // 语句2
    }

    public void method2() {
        if (flag) {
            this.i += 5; // 语句3
        }
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        InsReorderDemo demo = new InsReorderDemo();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                demo.method1();
                ;
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                demo.method2();
            }
        }, "B").start();
    }
}
