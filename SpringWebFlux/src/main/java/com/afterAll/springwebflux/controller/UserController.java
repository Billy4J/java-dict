package com.afterAll.springwebflux.controller;

import com.afterAll.springwebflux.entity.User;
import com.afterAll.springwebflux.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 基于注解编程模型
 */
@Log4j2
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public Mono<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user")
    public Flux<User> getAllUser() {
        log.info("get all user");
        return userService.getAllUser();
    }

    @PostMapping("user/add")
    public Mono<Void> addUser(@RequestBody User user) {
        Mono<User> userMono = Mono.just(user);
        return userService.addUser(userMono);
    }

    @PostMapping("/user/batchAdd")
    public Mono<Void> addBatch(@RequestBody List<User> users) {
        Flux<User> userFlux = Flux.fromIterable(users);
        return userService.batchAddUser(userFlux);
    }
}
