package com.zhoulychn.cases.multithread;

/**
 * Created by lewis on 2017/1/9.
 * 守护线程
 */
public class Daemon {

    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("end");
                SleepUtils.second(10);
                System.out.println("end");
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
