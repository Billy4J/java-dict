package com.afterAll.springwebflux.controller;

import com.afterAll.springwebflux.entity.User;
import com.afterAll.springwebflux.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;


@Component
public class UserHandler {

    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> getUserById(ServerRequest request) {
        //获取id值
        int id = Integer.parseInt(request.pathVariable("id"));
        //空值处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        //调用service方法得到数据
        Mono<User> userMono = this.userService.getUserById(id);
        //把userMono进行转换返回
        //使用Reactor操作符flatMap
        return userMono
                .flatMap(
                        user -> ServerResponse.ok()
                                .contentType(APPLICATION_JSON)
                                .body(fromObject(user))
                ).switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> getAllUser(ServerRequest request) {
        Flux<User> userFlux = this.userService.getAllUser();

        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return ServerResponse.ok().contentType(APPLICATION_JSON).body(userFlux, User.class).switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> addUser(ServerRequest request) {

        Mono<User> userMono = request.bodyToMono(User.class);

        return ServerResponse.ok().build(userService.addUser(userMono));
    }
}
