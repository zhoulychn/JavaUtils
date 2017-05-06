package com.zhoulychn.cases.pattern.结构.适配器;

/**
 * Created by lewis on 2017/2/26.
 * 适配器：将需要的方法继承到实现类，继承的方法也可以帮助实现接口的方法
 */
public class TestCase {
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method();
        target.methodNew();
    }
}
