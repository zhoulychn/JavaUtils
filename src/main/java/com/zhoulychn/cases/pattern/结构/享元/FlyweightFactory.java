package com.zhoulychn.cases.pattern.结构.享元;

import java.util.Hashtable;

/**
 * Created by lewis on 2017/2/27.
 */
public class FlyweightFactory {

    private Hashtable flyweights = new Hashtable();//----------------------------1

    public FlyweightFactory() {
    }

    public Flyweight getFlyWeight(Object obj) {
        Flyweight flyweight = (Flyweight) flyweights.get(obj);//----------------2
        if (flyweight == null) {//---------------------------------------------------3
            //产生新的ConcreteFlyweight
            flyweight = new ConcreteFlyweight((String) obj);
            flyweights.put(obj, flyweight);//--------------------------------------5}
        }
        return flyweight;//---------------------------------------------------------6
    }

    public int getFlyweightSize() {
        return flyweights.size();
    }
}
