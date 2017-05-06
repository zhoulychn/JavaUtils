package com.zhoulychn.service.impl;

import com.zhoulychn.bean.entity.AnchorBase;
import com.zhoulychn.bean.entity.AnchorBaseExample;
import com.zhoulychn.dao.base.AnchorBaseMapper;
import com.zhoulychn.service.TestService;
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
public class TestServiceImpl implements TestService {

    @Autowired
    private AnchorBaseMapper anchorBaseMapper;

    @Override
    @Cacheable(value = "myCache", key = "#id")
    public AnchorBase selectById(String id) {
        return anchorBaseMapper.selectByPrimaryKey(id);
    }


    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override

    public int insert(AnchorBase base) {
        return anchorBaseMapper.insert(base);
    }

    @Override
    @CacheEvict(value = "myCache", key = "#base.url")
    public int update(AnchorBase base) {
        return anchorBaseMapper.updateByPrimaryKey(base);
    }

    @Override
    @Cacheable(value = "myCache", key = "0")
    public int count() {
        return (int)anchorBaseMapper.countByExample(new AnchorBaseExample());
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
        AnchorBase anchorBase = anchorBaseMapper.selectByPrimaryKey("https://www.douyu.com/10");
        anchorBase.setUrl("--------------------------");
        anchorBaseMapper.insert(anchorBase);
    }
}
