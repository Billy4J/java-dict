package com.afterAll.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UserServiceProxy implements InvocationHandler {
    //1 把创建的是谁的代理对象，把谁传递过来
    // 有参数构造传递
    private Object obj;

    public UserServiceProxy(Object object) {
        this.obj = object;
    }

    /**
     * 增强的逻辑
     *
     * @param proxy  是真实的代理类对象
     * @param method 执行方法，可以返回真实的被代理对象
     * @param args   执行方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("原方法执行之前，参数：" + Arrays.toString(args));
        /*执行原始方法*/
        Object invoke = method.invoke(obj, args);
        System.out.println("方法之后执行....");
        System.out.println("proxy :" + proxy.getClass());
        System.out.println("invoke :" + invoke.getClass());
        return null;
    }
}
