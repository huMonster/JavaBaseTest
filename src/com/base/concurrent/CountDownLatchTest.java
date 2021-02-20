package com.base.concurrent;

import java.util.concurrent.CountDownLatch;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 闭锁
 * 吃鸡小分队人已经到齐，所有人准备后，才能开始游戏
 */
public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(4);
    private static class EatChicken extends Thread{
        private String name;
        private int readyTime;

        public EatChicken(String name, int time){
            this.name = name;
            this.readyTime = time;
        }

        @Override
        public void run() {
            System.out.println(name + "准备" + readyTime + "秒");
            try {
                SECONDS.sleep(readyTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "准备好了！");
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("-----等待所有人准备-----");
        EatChicken m416 = new EatChicken("m416", 1);
        EatChicken AWM = new EatChicken("AWM", 2);
        EatChicken SKS = new EatChicken("SKS", 3);
        EatChicken win94 = new EatChicken("win94", 2);

        m416.start();
        AWM.start();
        SKS.start();
        win94.start();

        countDownLatch.await();
        System.out.println("-----所有人准备好了-----");
        System.out.println("-----游戏开始-----");
        System.out.println("凸凸凸凸, game over!");
    }
}
