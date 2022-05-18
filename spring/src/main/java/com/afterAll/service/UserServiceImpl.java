package com.afterAll.service;

import com.afterAll.dao.UserDao;
import com.afterAll.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("add...");
    }

    @Override
    public UserService add(int x, int y) {
        System.out.println(x + y);
        return this;
    }

    public void addUser() {
        userDao.addUser(new User(33, "1111", null));
        int r = 1 / 0;
        userDao.addUser(new User(44, "222", null));
    }
}
