package com.base.colletion.unsafe;

import com.base.colletion.safe.CopyOnWriteHashMap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 线程不安全集合类之hashMap
 * @Author Monster
 * @Date 2021/1/25 13:37
 * @Version 1.0
 */
public class HashMapDemo {
    /**
     * hashMap线程不安全， hashtable线程安全
     * 效率： hashMap > hashTable
     * @param args
     */
    public static void main(String[] args) {
        // 名称     initCapacity  loadFactor    扩容
        // hashMap     16           0.75    capacity * 2
        // hashTable   11           0.75    capacity * 2 + 1
        HashMap<Object, Object> map = new HashMap<>();
        // hashMap key/value 可以为null，hashtable不可以key为null
        // hashMap以null为key时总是存储在table数组的第一个节点上
        map.put("", "");
        /**
         * 三种线程安全得hashMap
         */
        // 1、hashTable: synchronized在方法上加锁，使用同步阻塞，效率低
        Hashtable hashtable = new Hashtable();
        // 2、synchronizedMap：同hashTable
        Map<Object, Object> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        synchronizedMap.put(1, "1");
        // 3、concurrentHashMap: 分段锁技术、减小锁粒度、效率高
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();

        /** 也可以参考CopyOnWriteArrayList自己实现一个CopyOnWriteHashMap */
        CopyOnWriteHashMap copyOnWriteHashMap = new CopyOnWriteHashMap();
    }
}
