package com.zhoulychn.dao;

import com.zhoulychn.entity.UserEntity;
import com.zhoulychn.entity.UserEntityExample;
import org.springframework.stereotype.Repository;

/**
 * UserDAO继承基类
 */
@Repository
public interface UserDAO extends MyBatisBaseDao<UserEntity, Integer, UserEntityExample> {
}