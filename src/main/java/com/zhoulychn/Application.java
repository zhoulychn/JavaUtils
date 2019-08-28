package com.zhoulychn;

import com.zhoulychn.config.AppConfig;
import com.zhoulychn.service.impl.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-context.xml");
        UserServiceImpl bean = context.getBean(UserServiceImpl.class);
    }
}
