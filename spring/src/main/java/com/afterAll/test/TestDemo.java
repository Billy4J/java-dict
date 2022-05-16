package com.afterAll.test;

import com.afterAll.aop.AspectJWithAnnotationDemo;
import com.afterAll.dao.GoodDao;
import com.afterAll.dao.UserDao;
import com.afterAll.ioc.AnnotationDemo;
import com.afterAll.ioc.SpringConfig;
import com.afterAll.service.UserServiceImpl;
import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class TestDemo {

    /**
     * factoryBean 在配置文件定义bean类型可以和返回类型不一样
     */
    @Test
    public void testFactoryBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean_no_annotation.xml");
        GoodDao factoryBean = context.getBean("factoryBean", GoodDao.class);
        System.out.println(factoryBean.getName());
    }

    /**
     * 测试bean生命周期, 带有bean后置处理器的生命周期
     */
    @Test
    public void testBeanLifecycle() {
        /**
         * ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean_no_annotation.xml");
         * 此时context没有close方法
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean_no_annotation.xml");
        GoodDao beanLifecycle = context.getBean("beanLifecycle", GoodDao.class);
        System.out.println(beanLifecycle.getName());
        context.close();
    }

    /**
     * 测试使用注解方式管理bean：对象创建和属性注入
     */
    @Test
    public void testAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean_with_annotation.xml");
        AnnotationDemo annotationDemo = context.getBean("annotationDemo", AnnotationDemo.class);
        System.out.println();
    }

    /**
     * 测试完全基于注解开发
     */
    @Test
    public void testOnlyAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AnnotationDemo annotationDemo = context.getBean("annotationDemo", AnnotationDemo.class);
        System.out.println();
    }

    /**
     * 测试AOP框架基于xml开发
     */
    @Test
    public void testAspectJ() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean_aop.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.add();
    }

    /**
     * 测试AOP框架基于注解开发
     */
    @Test
    public void testAspectJOnlyAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AspectJWithAnnotationDemo.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.add();
    }

    /**
     * aspectJ配置文件，进行AOP操作
     */
    @Test
    public void testAspectJXmlOperation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aspectJ.xml");
        UserDao userServiceImpl = context.getBean("userDao", UserDao.class);
        userServiceImpl.add();
    }

    /**
     * 手动创建jdbcTemplate连接访问
     */
    @Test
    public void testJdbcTemplateManual() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Object> query = jdbcTemplate.query("select * from t_user where id=1", new BeanPropertyRowMapper<>(Object.class));
        System.out.println(query);
    }
}
