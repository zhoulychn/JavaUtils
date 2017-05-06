package com.zhoulychn.cases.pattern.结构.桥接;

/**
 * Created by lewis on 2017/2/27.
 */
public abstract class Bridge {

    private Source source;

    public void method() {
        source.method();
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
