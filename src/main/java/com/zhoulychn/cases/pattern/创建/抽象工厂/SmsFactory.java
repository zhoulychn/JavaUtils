package com.zhoulychn.cases.pattern.创建.抽象工厂;

/**
 * Created by lewis on 2017/2/26.
 */
public class SmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
