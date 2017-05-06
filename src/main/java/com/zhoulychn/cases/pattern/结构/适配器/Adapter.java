package com.zhoulychn.cases.pattern.结构.适配器;

/**
 * Created by lewis on 2017/2/26.
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void methodNew() {
        System.out.println("target");
    }
}
