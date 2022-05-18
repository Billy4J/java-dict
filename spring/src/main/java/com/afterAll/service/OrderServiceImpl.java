package com.afterAll.service;

import com.afterAll.dao.OrderDao;
import com.afterAll.entity.Order;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(
//        value = "",
//        transactionManager = "transactionManager"
//        , label = ""
//        , propagation = Propagation.REQUIRED
//        , isolation = Isolation.DEFAULT
//        , timeout = 5
//        , timeoutString = "time out"
//        , readOnly = false
//        , rollbackFor =
//        , rollbackForClassName = ""
//        , noRollbackFor =
//        , noRollbackForClassName = ""
)
@Data
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    public void transactionalTest() {
        orderDao.update(new Order(1, "修改"));
        int i = 1 / 0;
        orderDao.update(new Order(2, "修改"));
    }
}
