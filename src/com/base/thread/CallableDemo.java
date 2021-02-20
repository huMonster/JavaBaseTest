package com.base.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description 测试Callable接口
 * @Author Monster
 * @Date 2021/1/28 15:16
 * @Version 1.0
 */
class ImplCallable implements Callable{

    @Override
    public Integer call() throws Exception {
        System.out.println("进入了call接口");
        return 1024;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws Exception {
        // FutureTask（适配器模式）
        FutureTask<Integer> task = new FutureTask<>(new ImplCallable());

        Thread t = new Thread(task,"AAA");

        t.start();
        //
        int s = task.get();
        System.out.println();
    }
}
