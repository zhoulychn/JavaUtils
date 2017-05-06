package com.zhoulychn.cases.spring;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lewis on 2017/2/18.
 * 代理的两种实现
 */
public class ProxyCase {

    public static void main(String[] args) {

    }

    @Test
    public void jdk() {
        Mouth mouth = (Mouth) Proxy.newProxyInstance(Mouth.class.getClassLoader(), new Class[]{Mouth.class},
                (Object proxy, Method method, Object[] args) -> {
                    System.out.println(method.getName());
                    System.out.println(args);
                    return args[0];
                });
        mouth.say("hello");
    }

    @Test
    public void cglib() {
    }
}
