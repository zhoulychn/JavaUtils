package com.zhoulychn.config;

import com.zhoulychn.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class AppConfig {

    @Bean
    public UserServiceImpl getBean() {
        return new UserServiceImpl();
    }
}
