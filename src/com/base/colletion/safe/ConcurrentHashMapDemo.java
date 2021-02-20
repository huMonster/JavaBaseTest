package com.base.colletion.safe;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description ConcurrentHashMap死锁
 * @Author Monster
 * @Date 2021/1/25 15:58
 * @Version 1.0
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new ConcurrentHashMap<>(16);
        // computeIfAbsent 相当于 putIfAbsent
        // computeIfAbsent 存在时返回存在的值，如果不存在，就返回最新值，
        // putIfAbsent 存在时返回旧值，如果没有就返回null
        //        map.put("1", 1);
//        System.out.println(map.computeIfAbsent("1", k -> 2));
//        System.out.println(map.putIfAbsent("1", 2));
        map.put("1", 1);
        map.computeIfAbsent("AaAa", k -> {
            return map.computeIfAbsent("BBBB", k2 -> 42);
        });

        System.out.println("=============end================");
    }
}
