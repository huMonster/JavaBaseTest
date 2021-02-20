package com.base.clinit;

/**
 * @Description Father 类加载和实例加载机制
 * @Author Monster
 * @Date 2020/12/25 16:31
 * @Version 1.0
 */
public class Father {
    private int i = test();
    private static int j = method();

    static {
        System.out.print("2 ");
    }
    Father(){
        System.out.print("7 ");
    }
    {
        System.out.print("6 ");
    }
    private static int method() {
        System.out.print("1 ");
        return 0;
    }

    private int test() {
        System.out.print("5 ");
        return 0;
    }
}
