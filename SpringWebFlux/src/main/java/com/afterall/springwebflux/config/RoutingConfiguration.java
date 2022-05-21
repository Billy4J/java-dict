package com.afterall.springwebflux.config;

import com.afterall.springwebflux.controller.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RoutingConfiguration {
    @Bean
    public RouterFunction<ServerResponse> routingFunction(UserHandler userHandler) {
        return RouterFunctions.route(GET("/user2/{id}").and(accept(APPLICATION_JSON)), userHandler::getUserById)
                .andRoute(GET("/user2").and(accept(APPLICATION_JSON)), userHandler::getAllUser)
                .andRoute(POST("/user2/add").and(accept(APPLICATION_JSON)), userHandler::addUser);
    }
}
