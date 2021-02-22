package com.base.jvm.oom;

import java.util.concurrent.TimeUnit;

/**
 * @Description OOM之unable to create new native thread
 * @Author Monster
 * @Date 2021/2/20 16:10
 * @Version 1.0
 */
public class UnableCreateNewThread {
    /**
     * 错误： Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
     * 高并发请求服务器时，经常出现该异常，准确的讲该native thread异常与对应的平台有关
     *
     * 导致原因：
     *      1、创建太多的线程，一个应用进城创建多个线程，超过系统承载的极限
     *      2、服务器并不允许创建这么的线程，Linux系统默认单个进程可以创建的线程数是1024个，root用户没有限制
     *         应用创建超过这个数量，就会报java.lang.OutOfMemoryError: unable to create new native thread
     *  解决办法：
     *      1、降低应用程序创建的线程数量
     *      2、修改Linux服务器配置的默认的线程数限制
     *
     *  电商、金融、高并发场景
     *
     */
    public static void main(String[] args) {
        for (int i = 0;; i++) {
            System.out.println("************" + i);
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
