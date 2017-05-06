package com.zhoulychn.cases.pattern.结构.桥接;

/**
 * Created by lewis on 2017/2/27.
 */
public class SourceOne implements Source {
    @Override
    public void method() {
        System.out.println("one");
    }
}
