package com.zhoulychn.cases.pattern.结构.装饰;

/**
 * Created by lewis on 2017/2/26.
 * 基础类和装饰器实现相同的类，把基础类包装在装饰器里面，可以实现更多的方法
 */
public class TestCase {
    public static void main(String[] args) {
        Executable executable = new ChipDecorator(new Chip());
        executable.execute();
    }
}
