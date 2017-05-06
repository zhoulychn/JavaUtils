package com.zhoulychn.cases.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lewis on 2017/2/15.
 * ReentrantLock
 */
public class LockUseCase {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println("hello");
        } finally {
            lock.unlock();
        }

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 2; i != 0; i--) {
            cachedThreadPool.execute(() -> {
                try {
                    LockUseCase.tryLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void tryLock() throws InterruptedException {
        Lock lock = new ReentrantLock();
        boolean tryLock = lock.tryLock();
        System.out.println(tryLock);
        if (tryLock) {
            lock.lock();
            System.out.println("locked");
            Thread.sleep(100000);
            lock.unlock();
        }
    }
}
