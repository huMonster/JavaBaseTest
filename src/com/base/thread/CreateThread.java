package com.base.thread;

import java.util.concurrent.*;

/**
 * 创建线程的四种方式（前三种）
 */
class ExThread extends Thread{
    @Override
    public void run() {
        System.out.println("线程启动 extends");
    }
}
class ImpRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("线程启动 implements");
    }
}
class ImpCallable implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("线程启动 Callable");
        return Thread.currentThread().getId() + "";
    }
}

public class CreateThread{
    public static String pti(){
        System.out.println("线程启动");
        return "正是在下";
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 第一种
//        ExThread exThread = new ExThread();
//        exThread.start();

        // 第二种
//        Thread t = new Thread(new ImpRunnable());
//        t.start();

        // 第三种
        // 创建FutureTask对象
//        FutureTask<String> task = new FutureTask<String>(new ImpCallable());
//        // 创建Thread类对象
//        Thread t = new Thread(task);
//        t.start();
//        // 获取call()方法的返回值
//        String result = task.get();
//        System.out.println(result);

        // 第四种 线程池
        // 通过线程池工厂创建线程数量为2的线程池
//        ExecutorService service = Executors.newFixedThreadPool(2);
//        // execute()方法适用于实现Runnable接口创建的线程
//        service.execute(new ImpRunnable());
//        // submit()适用于Callable接口创建的线程
//        Future<String> future = service.submit(new ImpCallable());
//        // 获取call()返回值
//        String result = future.get();
//        System.out.println(result);
//        // 关闭线程池
//        service.shutdown();
        Thread t = new Thread(pti());

        t.start();
    }
}