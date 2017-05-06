package com.zhoulychn.cases.multithread;

import java.util.concurrent.TimeUnit;

/**
 * Created by lewis on 2017/1/9.
 * 休眠工具类
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }

}
