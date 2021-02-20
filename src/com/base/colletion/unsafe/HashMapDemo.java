package com.base.colletion.unsafe;

import java.util.*;

/**
 * @Description 线程不安全集合类之hashMap
 * @Author Monster
 * @Date 2021/1/25 13:37
 * @Version 1.0
 */
public class HashMapDemo {
    public static void main(String[] args) {
        // 扩容：capacity * 2
        HashMap<Object, Object> map = new HashMap<>();
        // hashMap key/value 可以为null，hashtable不可以
        // hashMap以null为key时总时存储在table数组的第一个节点上
        map.put("", "");
        Map<Object, Object> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        synchronizedMap.put(1, "1");
        // hashTable 初始容量为11， 负载因子 0.75
        // 扩容：capacity * 2 + 1
        Hashtable hashtable = new Hashtable();
        hashtable.put(1, "1");
        hashtable.put(2, "");
        hashtable.putIfAbsent(1, "2");
        System.out.println(hashtable.get(1));

    }
}
