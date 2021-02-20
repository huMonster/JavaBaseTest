package com.base.queue.blockingQqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description  同步队列是没有容量 ，与其他blockingQueue不同，是一个不存储元素的BlockingQueue
 * @Author Monster
 * @Date 2021/1/27 14:18
 * @Version 1.0
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {

        /**
         * put生产一个 take消费一个
         * 不消费就不生产下一个，队列一直等待消费（即阻塞）
         */
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        // 生产线程
        new Thread(()->{
            try {
                blockingQueue.put("a");
                blockingQueue.put("b");
                blockingQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        // 消费线程
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(blockingQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(blockingQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();
    }
}
