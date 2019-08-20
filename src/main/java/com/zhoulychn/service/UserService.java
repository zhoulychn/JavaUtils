package com.zhoulychn.service;

import com.zhoulychn.entity.UserEntity;

/**
 * Created by lewis on 2016/12/20.
 * 测试服务
 */
public interface UserService {

    UserEntity selectById(Integer id);

    int deleteById(Integer id);

    int insert(UserEntity entity);

    int update(UserEntity entity);

    int count();

    void sendEmail();

    void transactionCase();

}
