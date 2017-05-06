package com.zhoulychn.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by lewis on 2017/2/12.
 * 定时器案例
 */

@Component
public class Example {

    @Scheduled(cron = "0/10 * *  * * ? ")
    public void test() {

    }
}
