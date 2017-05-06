package com.zhoulychn.cases.pattern.创建.工厂.多工厂;

/**
 * Created by lewis on 2017/2/26.
 */

public class SendFactory {

    public Sender produceMail() {
        return new MailSender();
    }

    public Sender produceSms() {
        return new SmsSender();
    }
}
