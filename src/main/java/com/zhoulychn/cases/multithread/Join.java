package com.zhoulychn.cases.multithread;

import org.junit.Test;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by lewis on 2017/1/10.
 * thread join() 方法
 */
public class Join {

    public static void main(String[] args) throws Exception {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            // 每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }

    @Test
    public void joinCase() throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                System.out.println(finalI);
                try {
                    Thread.sleep(1000);
                    System.out.println(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            thread.join();
        }
        System.out.println(new Date());

    }
}
