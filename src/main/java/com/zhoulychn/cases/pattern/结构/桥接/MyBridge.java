package com.zhoulychn.cases.pattern.结构.桥接;

/**
 * Created by lewis on 2017/2/27.
 */
public class MyBridge extends Bridge {

    @Override
    public void method() {
        getSource().method();
    }
}
