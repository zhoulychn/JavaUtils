package com.zhoulychn.cases.pattern.结构.享元;

/**
 * Created by lewis on 2017/2/27.
 */
public class ConcreteFlyweight extends Flyweight {

    private String str;

    public ConcreteFlyweight(String str) {
        this.str = str;
    }

    @Override
    public void operation() {
        System.out.println("concrete--flyweight" + str);
    }
}
