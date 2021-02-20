package com.base.colletion.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description 集合类线程不安全之ArrayList
 * @Author Monster
 * @Date 2021/1/22 15:18
 * @Version 1.0
 */
public class ArrayListDemo {
    public static void main(String[] args) {
//        vector线程安全，并发性急剧下降
        List<String> vector = new Vector<>();
        // 线程不安全，性能高，单线程使用
//        List<String> list = new ArrayList<>();
        // 正确方法两种
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        // 底层原理是【写时复制】
        // 加锁->获取当前数组A->复制一份B，且长度加1 ->将数据写入B末尾->将B赋值当前数组A->解锁
        List<String> list = new CopyOnWriteArrayList<>();
        // 优雅，但性能表现差，名称是eta-conversion
        // list.forEach(System.out::println);
        // 增强for循环，性能高
//        for (String str:list) {
//            System.out.println(str);
//        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
        /**
         * 1、故障现象
         *         java.util.ConcurrentModificationException
         * 2、导致原因
         *         并发争抢修改导致，参考花名册签名例子
         *         一个同学正在写，另一个同学来争抢，导致异常
         * 3、解决方案
         *          3.1、new Vector<>()
         *          3.2、Collections.synchronizedList(new ArrayList<>());
         *          3.3、new CopyOnWriteArrayList<>()
         * 4、优化建议（避免再犯）
         */


    }
}
