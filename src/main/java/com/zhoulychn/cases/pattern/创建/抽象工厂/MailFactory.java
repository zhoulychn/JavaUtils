package com.zhoulychn.cases.pattern.创建.抽象工厂;

/**
 * Created by lewis on 2017/2/26.
 */
public class MailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
