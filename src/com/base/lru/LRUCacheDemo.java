package com.base.lru;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description LRUCacheDemo 利用linkedHashMap实现lru算法
 * @Author Monster
 * @Date 2021/1/8 15:24
 * @Version 1.0
 */
public class LRUCacheDemo<K,V> extends LinkedHashMap<K,V> {

    // 缓存坑位
    private int capacity;

    public LRUCacheDemo(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo lruCacheDemo = new LRUCacheDemo(3);
        lruCacheDemo.put(1, "a");
        lruCacheDemo.put(2, "b");
        lruCacheDemo.put(3, "c");
        lruCacheDemo.put(4, "d");
        System.out.println(lruCacheDemo.keySet());
    }
}
