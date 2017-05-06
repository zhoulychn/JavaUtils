package com.zhoulychn.cases.proxy;

/**
 * Created by lewis on 2017/2/20.
 */
public class MyMouth implements Mouth {

    @Override
    public void say(String word) {
        System.out.println(word);
    }
}
