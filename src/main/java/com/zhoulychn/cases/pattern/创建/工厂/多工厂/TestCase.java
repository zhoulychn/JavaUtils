package com.zhoulychn.cases.pattern.创建.工厂.多工厂;

/**
 * Created by lewis on 2017/2/26.
 * <p>
 * 多工厂:直接根据实现好的方法创建，不根据参数
 */
public class TestCase {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender mail = factory.produceMail();
        mail.send();
    }
}
