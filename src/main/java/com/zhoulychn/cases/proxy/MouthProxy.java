package com.zhoulychn.cases.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lewis on 2017/2/20.
 */
public class MouthProxy implements InvocationHandler {

    private Mouth mouth;

    MouthProxy(Mouth mouth) {
        this.mouth = mouth;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("open");
        mouth.say((String) args[0]);
        System.out.println("close");
        return null;
    }
}
