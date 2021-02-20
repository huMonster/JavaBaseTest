package com.base.concurrent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 相约吃鸡-并发问题
 */
public class CyclicBarrierTest {
    // 4个人约好下班后某个时间玩吃鸡
    private static CyclicBarrier barrier = new CyclicBarrier(4);

    private static class EatChickenPlayer extends Thread{
        // 姓名
        private String name;
        // 下班时间
        private Long offWorkTime;

        public EatChickenPlayer(String name, Long time){
            this.name = name;
            this.offWorkTime = time;
        }

        @Override
        public void run() {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("我是"+ name + ",我上号咯！");
                    try {
                        barrier.await();
                        System.out.println("开打开打！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }, offWorkTime);
        }
    }

    public static void main(String[] args) {
        EatChickenPlayer M416 = new EatChickenPlayer("m416", 400L);
        EatChickenPlayer AWM = new EatChickenPlayer("AWM", 300L);
        EatChickenPlayer SKS = new EatChickenPlayer("SKS", 350L);
        EatChickenPlayer WIN94 = new EatChickenPlayer("win94", 400L);

        M416.start();
        AWM.start();
    }

}
