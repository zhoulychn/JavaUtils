package com.zhoulychn.cases.pattern.创建.抽象工厂;


/**
 * Created by lewis on 2017/2/26.
 * <p>
 * 抽象工厂:工厂根据接口有不同实现，产品也根据接口有不同实现
 */
public class TestCase {
    public static void main(String[] args) {
        Provider provider = new MailFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
