package com.zhoulychn.cases.pattern.结构.代理;

/**
 * Created by lewis on 2017/2/26.
 * 基础类和代理类实现相同的类，把基础类包装在装饰器里面，可以在基础类的方法上做额外的操作
 */
public class TestCase {
    public static void main(String[] args) {
        Executable executable = new ChipDecorator(new Chip());
        executable.execute();
    }
}
