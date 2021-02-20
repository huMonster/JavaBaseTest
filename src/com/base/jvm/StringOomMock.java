package com.base.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description StringOomMock PermGen测试
 * @Author Monster
 * @Date 2020/12/30 14:22
 * @Version 1.0
 */
public class StringOomMock {
    static String base = "hello ";

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        while (true){
//            String str = base + base;
//            base = str;
//            list.add(str.intern());
//        }
        base = base + "eee";
        System.out.println(base.intern());
        System.out.println(base);
    }
}
