package com.zhoulychn.cases.pattern.创建.单例;

/**
 * Created by lewis on 2017/2/26.
 */
public class Singleton {
    private static Singleton instance = null;

    public Singleton getInstance() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}
