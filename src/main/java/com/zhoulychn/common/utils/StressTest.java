package com.zhoulychn.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lewis on 2017/1/15.
 */
public class StressTest {

    public static void main(String[] args) throws IOException {

        /*String url = "http://chouxiang.tv/forum.php";
        Connection connect = Jsoup.connect(url);
        Connection.Response execute = connect.execute();
        String body = execute.body();
        System.out.println(body);*/
        String url = "http://chouxiang.tv/forum.php";
        final Connection connect = Jsoup.connect(url);
        int size = 600;
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(size);
        for (int i = 0; i < size; i++) {
            final int finalI = i;
            fixedThreadPool.execute(() -> {
                System.out.println("线程" + finalI);
                while (true) {
                    try {
                        Connection.Response execute = connect.execute();
                    } catch (IOException e) {
                    }
                }
            });
        }
    }
}
