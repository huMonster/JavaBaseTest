package com.base.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 五个人四个坑，资源抢占
 */
public class SemaphoreTest {
    private static Semaphore semaphore = new Semaphore(4);

    private static class EatChickenPlayer extends Thread{
        private String name;

        public EatChickenPlayer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            if(semaphore.tryAcquire()){
                System.out.println(name + ":我进入游戏啦");
            } else {
                System.out.println(name + ":卧槽，队伍满了");
            }
        }
    }

    public static void main(String[] args) {
        EatChickenPlayer M416 = new EatChickenPlayer("m416");
        EatChickenPlayer AWM = new EatChickenPlayer("AWM");
        EatChickenPlayer SKS = new EatChickenPlayer("SKS");
        EatChickenPlayer WIN94 = new EatChickenPlayer("win94");
        EatChickenPlayer AKM = new EatChickenPlayer("AKM");

        M416.start();
        AWM.start();
        SKS.start();
        WIN94.start();
        AKM.start();
    }
}
