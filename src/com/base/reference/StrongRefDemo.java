package com.base.reference;

/**
 * @Description 强引用: 宁愿OOM，也不回收
 * @Author Monster
 * @Date 2021/2/19 14:15
 * @Version 1.0
 */
public class StrongRefDemo {
    public static void main(String[] args) {
        // ob1和ob2都强引用
        Object ob1 = new Object();
        // ob2引用赋值
        Object ob2 = ob1;
        // 置空
        ob1 = null;
        System.gc();
        System.out.println(ob2);
    }
}
