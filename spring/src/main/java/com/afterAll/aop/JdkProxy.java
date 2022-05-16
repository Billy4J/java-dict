package com.afterAll.aop;

import com.afterAll.service.UserService;
import com.afterAll.service.UserServiceImpl;

import java.lang.reflect.Proxy;

/**
 * aop原理
 */
public class JdkProxy {

    public static void main(String[] args) {
        /* 创建实现接口数组 */
        Class[] interfaces = {UserService.class};
        /* 创建接口实现类对象 */
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        /* 创建关联的调用处理程序类，注入被代理对象*/
        UserServiceProxy userServiceProxy = new UserServiceProxy(userServiceImpl);
        /*创建接口实现类代理对象*/
        UserService proxy = (UserService) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), interfaces, userServiceProxy);
        /*执行目标方法*/
        proxy.add(1, 2);
    }
}
