package com.zhoulychn;

import com.zhoulychn.service.UserService;
import com.zhoulychn.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-context.xml");
        UserService bean = context.getBean(UserService.class);
    }
}
