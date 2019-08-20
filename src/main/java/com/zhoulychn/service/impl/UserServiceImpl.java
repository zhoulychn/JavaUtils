package com.zhoulychn.service.impl;

import com.zhoulychn.dao.UserDAO;
import com.zhoulychn.entity.UserEntity;
import com.zhoulychn.entity.UserEntityExample;
import com.zhoulychn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lewis on 2016/12/20.
 * 测试service
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Cacheable(value = "myCache", key = "#id")
    public UserEntity selectById(Integer id) {
        return userDAO.selectByPrimaryKey(id);
    }


    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override

    public int insert(UserEntity base) {
        return userDAO.insert(base);
    }

    @Override
    @CacheEvict(value = "myCache", key = "#base.url")
    public int update(UserEntity base) {
        return userDAO.updateByPrimaryKey(base);
    }

    @Override
    @Cacheable(value = "myCache", key = "0")
    public int count() {
        return (int) userDAO.countByExample(new UserEntityExample());
    }

    @Override
    @Async
    public void sendEmail() {
        try {
            Thread.sleep(10000);
            System.out.println("异步方法");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    public void transactionCase() {
        UserEntity anchorBase = userDAO.selectByPrimaryKey(1);
        userDAO.insert(anchorBase);
    }
}
