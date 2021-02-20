package com.base.queue.blockingQqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description 阻塞队列 FIFO
 *              2.1 阻塞队列有没有好的一面
 *                  例如：吃饭排队等候，候客区就是阻塞队列
 *              2.2 不得不阻塞，如何管理
 *
 * @Author Monster
 * @Date 2021/1/26 17:40
 * @Version 1.0
 */
public class ArrayBlockingQueueDemo {
    /**
     * 阻塞队列：当队列是空的时候，从队列里获取元素将会被阻塞
     *          当队列是满的时候，向队列里添加元素将会被阻塞
     *   例如：买蛋糕，柜子满了，新的蛋糕放不进去，柜子空了，客户买不了了
     *   为什么使用BlockingQueue?线程的唤醒和阻塞（wait/notify）不用再关注，自动管理
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
//        List<String> list = new ArrayList<>();
        // BlockingDeque 由链表组成的双向阻塞队列
        // ArrayBlockingQueue 由数组组成的有界阻塞队列
        //指定队列空闲位置3个
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        /**
         * 第一组：一言不合报异常 add(e)、remove()、element()
         */
//        queue.add("a");
//        queue.add("b");
//        queue.add("c");
        // FIFO 移出队首,并返回移除的元素，也可以指定移出某个元素remove("c")
//        String s = queue.remove();
        // 弹出队首元素，且不移出队列，没有报异常
//        System.out.println(queue.element());

        /**
         * 第二组：不报异常的操作 offer(e) poll() peek()
         */
        // 成功true 失败false offer(e)
//        queue.offer("a");
//        queue.offer("b");
//        queue.offer("c");
//        System.out.println(queue.offer("d"));
//        // 弹出首位元素并返回，且队列中不在保存
//        // 当队列中没有元素时，返回null
//        System.out.println(queue.poll());
//        // 取首位元素，但不移出队列，元素没有返回null
//        System.out.println(queue.peek());

        /**
         * 第三组：操作不成功就一直阻塞 put(e) take()
         */
//        queue.put("a");
//        queue.put("b");
//        queue.put("c");
        // 不成功一直阻塞
//        queue.put("d");
//
//        queue.take();
//        queue.take();
//        queue.take();
        // 不成功一直阻塞
//        queue.take();
        /**
         * 第四组：超时退出（过时不候）
         */
        queue.offer("a", 2L, TimeUnit.SECONDS);
        queue.offer("b", 2L, TimeUnit.SECONDS);
        queue.offer("c", 2L, TimeUnit.SECONDS);
        // 超时返回false
        System.out.println(queue.offer("d", 2L, TimeUnit.SECONDS));

        queue.poll(2L, TimeUnit.SECONDS);
        queue.poll(2L, TimeUnit.SECONDS);
        queue.poll(2L, TimeUnit.SECONDS);
        // 超时返回null
        System.out.println(queue.poll(2L, TimeUnit.SECONDS));

        System.out.println(queue);
    }
}
