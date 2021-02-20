package com.base.colletion.unsafe;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @Description 弱引用测试
 * @Author Monster
 * @Date 2021/2/19 16:01
 * @Version 1.0
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();
        System.out.println("-------------------");
        myWeakHashMap();
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();
        Integer key = new Integer(1);
        String value = "WeakHashMap";
        weakHashMap.put(key, value);
        System.out.println(weakHashMap);

        key = null;
        System.out.println(weakHashMap);

        System.gc();
        System.out.println(weakHashMap + "*************" + weakHashMap.size());
    }

    private static void myHashMap(){
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";

        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "*************" + map.size());
    }
}
