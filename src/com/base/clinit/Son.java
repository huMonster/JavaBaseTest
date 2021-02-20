package com.base.clinit;

/**
 * @Description Son
 * @Author Monster
 * @Date 2020/12/25 16:36
 * @Version 1.0
 */
public class Son extends Father {

    private int i = test();
    private static int j = method();

    Son() {
        System.out.print("10 ");
    }

    private static int method() {
        System.out.print("3 ");
        return 0;
    }
    static {
        System.out.print("4 ");
    }
    {
        System.out.print("9 ");
    }

    private int test() {
        System.out.print("8 ");
        return 0;
    }

    public static void main(String[] args) {
        Son s = new Son();
    }
}
