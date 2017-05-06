package com.zhoulychn.cases.algorithm.回文数;

/**
 * Created by lewis on 2017/2/26.
 */
public class Example {

    public static void main(String[] args) {
        System.out.println(Example.runCase("12344321"));
        System.out.println(Example.runCase("123454321"));
        System.out.println(Example.runCase("123456789"));
    }

    public static boolean runCase(String str) {
        return new StringBuilder(str.substring(0, str.length() / 2)).reverse().toString()
                .equals(str.substring(str.length() % 2 == 0 ? str.length() / 2 : str.length() / 2 + 1, str.length()));
    }
}
