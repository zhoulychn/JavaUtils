package com.zhoulychn.cases.pattern.创建.建造者;


/**
 * Created by lewis on 2017/2/26.
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("send sms");
    }
}
