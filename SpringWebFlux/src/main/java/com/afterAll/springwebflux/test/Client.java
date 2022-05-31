package com.afterAll.springwebflux.test;

import com.afterAll.springwebflux.entity.User;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class Client {
    public static void main(String[] args) {
        //调用服务器地址
        WebClient webClient = WebClient.create("http://127.0.0.1:7777");
        //根据id查询
        String id = "1";
        User user = webClient.get().uri("/user2/{id}", id).accept(APPLICATION_JSON).retrieve().bodyToMono(User.class).block();
        System.out.println(user.getName());
        //查询所有
        Flux<User> results = webClient.get().uri("/user2").accept(APPLICATION_JSON).retrieve().bodyToFlux(User.class);
        results.map(User::getName).buffer().doOnNext(System.out::println).blockFirst();
    }
}