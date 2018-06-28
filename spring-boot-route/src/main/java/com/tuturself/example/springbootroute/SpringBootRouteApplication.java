package com.tuturself.example.springbootroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@SpringBootApplication
public class SpringBootRouteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRouteApplication.class, args);
    }

    @Bean
    RouterFunction<?> routes(EmployeeRepository er) {
        return RouterFunctions.route(RequestPredicates.GET("/employees"),
                r -> ServerResponse.ok().body(Flux.just(er.findAll()), List.class))
                .andRoute(RequestPredicates.GET("/employees/{id}"),
                        r -> ServerResponse.ok().body(Flux.just(er.findById(r.pathVariable("id"))), List.class))
                .andRoute(RequestPredicates.GET("/delay"),
                        r -> ServerResponse.ok().body(Flux.just("Hello World!").delayElements(
                                Duration.ofSeconds(10000)), String.class));

    }
}
