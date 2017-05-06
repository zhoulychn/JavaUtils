package com.zhoulychn.cases.pattern.结构.享元;

/**
 * Created by lewis on 2017/2/27.
 * 可以共享的对象.也就是说返回的同一类型的对象其实是同一实例。
 * 当客户端要求生成一个对象时，工厂会检测是否存在此对象的实例，如果存在那么直接返回此对象实例。
 * 如果不存在就创建一个并保存起来，这点有些单例模式的意思。
 * 通常工厂类会有一个集合类型的成员变量来用以保存对象，如hashtable,vector等。
 * 在java中，数据库连接池，线程池等即是用享元模式的应用。
 */
public class TestCase {
    FlyweightFactory factory = new FlyweightFactory();
    Flyweight fly1;
    Flyweight fly2;
    Flyweight fly3;
    Flyweight fly4;
    Flyweight fly5;
    Flyweight fly6;
/** */
    /**
     * Creates a new instance of FlyweightPattern
     */
    public TestCase() {
        fly1 = factory.getFlyWeight("Google");
        fly2 = factory.getFlyWeight("Qutr");
        fly3 = factory.getFlyWeight("Google");
        fly4 = factory.getFlyWeight("Google");
        fly5 = factory.getFlyWeight("Google");
        fly6 = factory.getFlyWeight("Google");
    }

    public void showFlyweight() {
        fly1.operation();
        fly2.operation();
        fly3.operation();
        fly4.operation();
        fly5.operation();
        fly6.operation();
        int objSize = factory.getFlyweightSize();
        System.out.println("objSize = " + objSize);
    }

    public static void main(String[] args) {
        System.out.println("The FlyWeight Pattern!");
        TestCase fp = new TestCase();
        fp.showFlyweight();
    }
}
