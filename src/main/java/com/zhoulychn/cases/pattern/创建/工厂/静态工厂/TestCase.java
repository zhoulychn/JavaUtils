package com.zhoulychn.cases.pattern.创建.工厂.静态工厂;

/**
 * Created by lewis on 2017/2/26.
 * <p>
 * 静态工厂:多工厂的静态方法版。
 */
public class TestCase {
    public static void main(String[] args) {
        Sender mail = SendFactory.produceMail();
        mail.send();
    }
}
