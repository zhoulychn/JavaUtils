package com.zhoulychn.cases.proxy;


import java.lang.reflect.Proxy;

/**
 * Created by lewis on 2017/2/20.
 */
public class ProxyCase {

    public static void main(String[] args) {
        Mouth mouth = (Mouth) Proxy.newProxyInstance(Mouth.class.getClassLoader(), new Class[]{Mouth.class}, new MouthProxy(new MyMouth()));
        mouth.say("hello");
    }
}
