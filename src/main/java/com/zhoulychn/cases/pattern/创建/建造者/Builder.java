package com.zhoulychn.cases.pattern.创建.建造者;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lewis on 2017/2/26.
 */
public class Builder {

    private List<Sender> list = new ArrayList<>();

    public void produceMail(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSms(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }
}
