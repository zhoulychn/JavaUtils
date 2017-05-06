package com.zhoulychn.cases.pattern.创建.工厂.普通工厂;

/**
 * Created by lewis on 2017/2/26.
 */
public class SendFactory {

    public Sender produce(String type) {
        if ("mail".equals(type))
            return new MailSender();
        if ("sms".equals(type))
            return new SmsSender();
        return null;
    }
}
