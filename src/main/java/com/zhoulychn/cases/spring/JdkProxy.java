package com.zhoulychn.cases.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lewis on 2017/2/18.
 * JDK代理类
 */
public class JdkProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(args[0]);
        return args[0];
    }

}
