package com.base.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description HeadOomMock
 * @Author Monster
 * @Date 2020/12/30 13:43
 * @Version 1.0
 */
public class HeadOomMock {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        int i = 0;
        boolean flag = true;
        while(flag){
            try {
                i++;
                list.add(new byte[1024*1024]);// 每次增加一个1M大小的数组对象
            } catch (Throwable e) {
                flag = false;
                System.out.println("运行次数：" + i);
                e.printStackTrace();
            }
        }
    }
}
