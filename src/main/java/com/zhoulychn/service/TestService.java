package com.zhoulychn.service;

import com.zhoulychn.bean.entity.AnchorBase;

/**
 * Created by lewis on 2016/12/20.
 * 测试服务
 */
public interface TestService {

    AnchorBase selectById(String id);

    int deleteById(String id);

    int insert(AnchorBase base);

    int update(AnchorBase base);

    int count();

    void sendEmail();

    void transactionCase();

}
