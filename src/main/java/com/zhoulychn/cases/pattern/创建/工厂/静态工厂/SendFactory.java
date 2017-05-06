package com.zhoulychn.cases.pattern.创建.工厂.静态工厂;

/**
 * Created by lewis on 2017/2/26.
 */

public class SendFactory {

    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }
}
