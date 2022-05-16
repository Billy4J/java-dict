package com.afterAll.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class AspectJWithXmlDemo {

    //相同切入点抽取
    @Pointcut(value = "execution(public * com.afterAll.dao.UserDao.add(..))")
    public void pointDemo() {
    }

    ///前置通知
    @Before(value = "pointDemo()")
    public void before() {
        System.out.println("before...");
    }

    //最终通知
    @After(value = "pointDemo()")
    public void after() {
        System.out.println("after...");
    }

    //环绕通知
    @Around(value = "pointDemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.........");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后.........");
    }

    //异常通知
    @AfterThrowing(value = "pointDemo()")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }

    //后置通知（返回通知）
    @AfterReturning(value = "pointDemo()")
    public void afterReturning() {
        System.out.println("afterReturn...");
    }
}
