package com.zhoulychn.cases.pattern.创建.工厂.普通工厂;

/**
 * Created by lewis on 2017/2/26.
 * <p>
 * 普通工厂:对同一接口根据情况创建不同的实现类。
 */
public class TestCase {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender mail = factory.produce("mail");
        mail.send();
    }
}
