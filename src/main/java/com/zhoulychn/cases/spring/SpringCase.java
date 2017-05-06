package com.zhoulychn.cases.spring;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by lewis on 2017/2/17.
 * spring测试
 */
public class SpringCase {

    @Test
    public void iocCase() {
        //IoC配置文件的抽象资源,初始化类加载器。resource包含文件路径和类加载器（通常是sun.misc.Launcher$AppClassLoader）。
        ClassPathResource resource = new ClassPathResource("spring/spring-database.xml");

        //创建bean工厂DefaultListableBeanFactory。
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //创建BeanDefinition的读取器，并讲bean工厂配置到读取器中。
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        //读取资源文件，载入注册bean到IoC容器
        reader.loadBeanDefinitions(resource);
    }

    @Test
    public void ioc() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-database.xml");
        Object obj = context.getBean("transactionManager");
    }

    @Test
    public void example() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Constructor<ArrayList> defaultConstructor = ArrayList.class.getDeclaredConstructor();
        ArrayList arrayList = defaultConstructor.newInstance();
        arrayList.add("a");
        System.out.println(arrayList);
    }
}
