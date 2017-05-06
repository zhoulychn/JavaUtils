package com.zhoulychn.cases.pattern.创建.原型;

import java.io.IOException;

/**
 * Created by lewis on 2017/2/26.
 */
public class TestCase {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Prototype first = new Prototype();
        first.setProperty(new Property());
        Prototype second = first.clone();
        Prototype third = first.deepClone();
        System.out.println("对象是否相等：" + (first == second));
        System.out.println("属性是否相等：" + (first.getProperty() == second.getProperty()));

        System.out.println("对象是否相等：" + (first == third));
        System.out.println("属性是否相等：" + (first.getProperty() == third.getProperty()));
    }
}
