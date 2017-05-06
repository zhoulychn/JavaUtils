package com.zhoulychn.cases.pattern.结构.桥接;

/**
 * Created by lewis on 2017/2/27.
 * 桥接模式就是把事物和其具体实现分开，使他们可以各自独立的变化
 */
public class TestCase {
    public static void main(String[] args) {
        Bridge bridge = new MyBridge();

        /*调用第一个对象*/
        bridge.setSource(new SourceOne());
        bridge.method();

        /*调用第二个对象*/
        bridge.setSource(new SourceTwo());
        bridge.method();
    }
}
