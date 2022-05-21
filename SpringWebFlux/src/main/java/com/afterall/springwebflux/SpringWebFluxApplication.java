package com.afterall.springwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.reactive.config.EnableWebFlux;

@ComponentScan(basePackages = {"com.afterall"})
@PropertySource("classpath:application.properties")
@SpringBootApplication
//@EnableWebFlux
public class SpringWebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebFluxApplication.class, args);
    }

}

