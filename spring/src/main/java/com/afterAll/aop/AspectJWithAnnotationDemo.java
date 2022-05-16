package com.afterAll.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * AOP框架，完全使用注解开发
 */
@Configuration
@ComponentScan(value = {"com.afterAll"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectJWithAnnotationDemo {
}
