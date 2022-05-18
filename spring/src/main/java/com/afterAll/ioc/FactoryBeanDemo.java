package com.afterAll.ioc;

import com.afterAll.entity.Good;
import org.springframework.beans.factory.FactoryBean;

public class FactoryBeanDemo implements FactoryBean<Good> {
    @Override
    public Good getObject() {
        Good good = new Good();
        good.setName("factoryBeanTest-Good");
        return good;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
