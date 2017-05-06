package com.zhoulychn.cases.multithread;

import java.util.concurrent.*;

/**
 * Created by lewis on 2017/2/23.
 */
public class ThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> result1 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "I";
            }
        });
        Future<String> result2 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "am";
            }
        });
        Future<String> result3 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "lewis";
            }
        });
        System.out.println(result1.get() + " " + result2.get() + " " + result3.get());
    }
}
