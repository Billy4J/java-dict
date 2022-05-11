package com.afterAll.ioc;

import com.afterAll.dao.GoodDao;
import org.springframework.beans.factory.FactoryBean;

public class FactoryBeanDemo implements FactoryBean<GoodDao> {
    @Override
    public GoodDao getObject() {
        GoodDao goodDao = new GoodDao();
        goodDao.setName("factoryBeanTest-GoodDao");
        return goodDao;
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
