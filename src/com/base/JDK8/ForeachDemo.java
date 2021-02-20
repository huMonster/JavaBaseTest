package com.base.JDK8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description JDK8 ForEach性能测试
 * @Author Monster
 * @Date 2021/1/28 14:56
 * @Version 1.0
 */
public class ForeachDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(1000000);
        for (int i = 1; i <= 100000; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();
            list.forEach(u ->{
                if(u != 0){

                }
            });
//        for (int i : list) {
//            if( i != 0){
//
//            }
//        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }
}
