package com.afterAll.service;


import com.afterAll.dao.GoodDao;
import com.afterAll.entity.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "transactionManagerAnnotation")
public class GoodService {
    @Autowired
    private GoodDao goodDao;

    public void add() {
        goodDao.addGood(new Good(11, "1111"));
        int i = 1 / 0;
        goodDao.addGood(new Good(2, "222"));
    }
}
