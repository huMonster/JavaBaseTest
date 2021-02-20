package com.base.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description LRUDemo
 * @Author Monster
 * @Date 2021/1/8 16:10
 * @Version 1.0
 */
public class LRUDemo {

    // 构造Node作为数据载体
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    // 虚拟的双向链表
    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        // 2.1 构造方法
        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        // 2.2 添加头节点
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // 2.3 删除节点
        public void removeNode(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

        // 2.4 获得最后一个节点
        public Node getLast() {
            return tail.prev;
        }
    }

    private int cacheSize;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUDemo(int cacheSize) {
        this.cacheSize = cacheSize;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }


    // read
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);

        return node.value;
    }

    // save or update
    public void put(int key, int value){
        // update
        if(map.containsKey(key)){
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);

            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {
            if(map.size() == cacheSize){
                Node<Integer, Integer> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }

            Node<Integer, Integer> newNode = new Node<>(key, value);
            map.put(key, newNode);
            doubleLinkedList.addHead(newNode);
        }
    }

    public static void main(String[] args) {
        LRUDemo lruDemo = new LRUDemo(3);
        lruDemo.put(1, 1);
        lruDemo.put(2, 2);
        lruDemo.put(3, 3);
        lruDemo.put(4, 4);
        lruDemo.put(5, 3);
        System.out.println(lruDemo.map.keySet());
    }
}
