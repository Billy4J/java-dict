package com.afterAll.test;

import com.afterAll.aop.AspectJWithAnnotationDemo;
import com.afterAll.dao.GoodDao;
import com.afterAll.dao.OrderDao;
import com.afterAll.dao.UserDao;
import com.afterAll.entity.Good;
import com.afterAll.entity.Order;
import com.afterAll.ioc.AnnotationDemo;
import com.afterAll.ioc.SpringConfig;
import com.afterAll.jdbc.SpringConfigJdbc;
import com.afterAll.service.GoodService;
import com.afterAll.service.OrderServiceImpl;
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

import java.util.ArrayList;
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
        Good factoryBean = context.getBean("factoryBean", Good.class);
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
        System.out.println(annotationDemo.getUserDao());
    }

    /**
     * 测试完全基于注解开发
     */
    @Test
    public void testOnlyAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AnnotationDemo annotationDemo = context.getBean("annotationDemo", AnnotationDemo.class);
        System.out.println(annotationDemo.getUserDao());
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
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.add();
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

    /**
     * JDBC框架基于xml操作
     */
    @Test
    public void testJdbcWithXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:jdbcTemplate.xml");
        OrderDao orderDao = context.getBean("orderDao", OrderDao.class);
        Order order = new Order(4, "第四个");
//        orderDao.add(order);
//        order.setName("测试更新操作");
//        orderDao.update(order);
//        orderDao.delete(order);
//        orderDao.findOrderInfo(4);
//        orderDao.findAllOrder();
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(55, "555---"));
        orders.add(new Order(66, "666---"));
        orders.add(new Order(77, "777---"));
//        orderDao.batchAddOrderObj(orders);
//        orderDao.batchUpdateOrderObj(orders);
//        orderDao.batchDeleteOrderObj(orders);
    }

    /**
     * 测试事务操作
     */
    @Test
    public void testTransaction() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:jdbcTemplate.xml");
        OrderServiceImpl orderServiceImpl = context.getBean("orderServiceImpl", OrderServiceImpl.class);
        orderServiceImpl.transactionalTest();
    }

    /**
     * 基于xml声明式事务管理
     */
    @Test
    public void testTransactionWithXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:transactionalInXml.xml");
        UserServiceImpl userServiceImpl = context.getBean("userServiceImpl", UserServiceImpl.class);
        userServiceImpl.addUser();
    }


    /**
     * 完全基于注解声明式进行事务管理
     */
    @Test
    public void testTransactionalOnlyAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigJdbc.class);
        GoodService goodService = context.getBean("goodService", GoodService.class);
        goodService.add();
        System.out.println();
    }

}
