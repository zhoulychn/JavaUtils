package com.zhoulychn.cases.multithread;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lewis on 2017/2/15.
 * 线程池用例
 */
public class ThreadPoolExecutorCase {

    private static AtomicInteger atom = new AtomicInteger(0);

    public static void main(String[] args) {
    }

    @Test
    public void doExecute() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 2; i++) {
            service.execute(() -> {
                System.out.println(atom.incrementAndGet());
            });
        }
        Thread.yield();
        System.out.println(atom.get());
    }

    @Test
    public void doSubmit() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 2; i++) {
            Future<?> result = service.submit(() -> {
                System.out.println(atom.incrementAndGet());
            });
            try {
                System.out.println(result.get());
            } catch (Exception e) {
                e.printStackTrace();
                service.shutdown();
            }
        }
    }
}
