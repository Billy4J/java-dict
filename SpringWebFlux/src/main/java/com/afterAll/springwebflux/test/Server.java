package com.afterAll.springwebflux.test;

import com.afterAll.springwebflux.config.RoutingConfiguration;
import com.afterAll.springwebflux.controller.UserHandler;
import com.afterAll.springwebflux.dao.UserDao;
import com.afterAll.springwebflux.service.UserService;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;


import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class Server {

    public void createReactorServer() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        UserDao userDao = new UserDao();
        userDao.setJdbcTemplate(jdbcTemplate);
        UserService userService = new UserService();
        userService.setUserDao(userDao);
        UserHandler userHandler = new UserHandler(userService);

        //路由和handler适配
        RouterFunction<ServerResponse> route = new RoutingConfiguration().routingFunction(userHandler);
        HttpHandler httpHandler = toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        //创建服务器
        HttpServer httpServer = HttpServer.create();
        httpServer.port(7777).handle(adapter).bindNow();
    }

    //最终调用
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit");
        System.in.read();
    }
}
