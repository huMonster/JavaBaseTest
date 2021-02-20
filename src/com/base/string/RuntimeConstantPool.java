package com.base.string;

/**
 * @Description RuntimeConstantPool 运行时常量池及 intern()方法测试
 * @Author Monster
 * @Date 2020/12/30 15:51
 * @Version 1.0
 */
public class RuntimeConstantPool {

    public static void main(String[] args) {
        String str1 = new String("计算机");
        str1 += "软件";
        System.out.println(str1 == str1.intern());
        String str2 = new String("ja");
        str2 += "va";
        System.out.println(str2 == str2.intern());
    }
}
