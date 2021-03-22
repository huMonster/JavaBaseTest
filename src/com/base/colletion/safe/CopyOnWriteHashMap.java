package com.base.colletion.safe;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description 参考 CopyOnWriteArrayList实现
 * @Author Monster
 * @Date 2021/3/22 11:29
 * @Version 1.0
 */
public class CopyOnWriteHashMap<K, V> implements Map<K, V>, Cloneable{

    private volatile Map<K, V> internalMap;

    public CopyOnWriteHashMap() {
        this.internalMap = new HashMap<>();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return internalMap.get(key);
    }

    @Override
    public V put(K key, V value) {
        synchronized (this){
            Map<K, V> newMap = new HashMap<>(internalMap);
            V val = newMap.put(key, value);
            internalMap = newMap;
            return val;
        }
    }

    @Override
    public V remove(Object key) {
        synchronized (this){
            return internalMap.remove(key);
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        synchronized (this){
            HashMap<K, V> newMap = new HashMap<>(internalMap);
            newMap.putAll(m);
            internalMap = newMap;
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
