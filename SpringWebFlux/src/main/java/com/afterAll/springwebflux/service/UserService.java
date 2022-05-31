package com.afterAll.springwebflux.service;

import com.afterAll.springwebflux.dao.UserDao;
import com.afterAll.springwebflux.entity.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@Service
@Data
public class UserService {
    @Autowired
    private UserDao userDao;

    public Mono<User> getUserById(int id) {
        log.info("get user by id");
        return Mono.justOrEmpty(userDao.findUser(id));
    }

    public Flux<User> getAllUser() {
        return Flux.fromIterable(userDao.findAllUser());
    }

    public Mono<Void> addUser(Mono<User> userMono) {
        return userMono.doOnNext(user -> userDao.addUser(user)).thenEmpty(Mono.empty());
    }

    public Mono<Void> batchAddUser(Flux<User> userFlux) {
        return userFlux.buffer().doOnNext(users -> userDao.batchAddUser(users)).thenEmpty(Flux.empty());
    }

}
