package com.base.queue.blockingQqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 生产消费者-阻塞队列版本
 *               volatile/CAS/atomicInteger/BlockQueue/线程交互
 * @Author Monster
 * @Date 2021/1/27 17:14
 * @Version 1.0
 */
class MyResource{
    // 默认开启，进行生产+消费
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue blockingQueue = null;

    // 传接口，可用性多，可以传进来ArrayBlockingQueue、LinkedBlockingQueue等等
    // 写：足够的抽象往高处写
    // 查：足够的落地往细节落地
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception{
        String data = null;
        while (FLAG){
            data = atomicInteger.getAndIncrement() + "";
            boolean result = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if(result){
                System.out.println(Thread.currentThread().getName() +"插入队列 " + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() +"插入队列 " + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "大老板叫停！FLAG=" + FLAG);
    }

    public void myConsumer() throws Exception{
        String result = null;
        while (FLAG){
            result = (String) blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(result == null || result.equalsIgnoreCase("")){
                FLAG = false;
                System.out.println("超过两秒中没有收取到蛋糕");
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列" + result + "成功！");
        }
        System.out.println(Thread.currentThread().getName() + "大老板叫停！FLAG=" + FLAG + "不生产了");
    }

    public void stop(){
        this.FLAG = false;
    }
}
public class ProConsumer_BlockQueueDemo {

    public static void main(String[] args) {
        /**
         * 不用考虑什么时候阻塞，什么时候唤醒，blockingQueue已经自动决定
         */
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动！");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Pro").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 消费者线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("时间到，线程停止！");
        myResource.stop();
    }
}
