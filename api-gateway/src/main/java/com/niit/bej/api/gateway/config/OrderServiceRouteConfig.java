package com.niit.bej.api.gateway.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@LoadBalancerClient
public class OrderServiceRouteConfig {
    @Bean
    @LoadBalanced
    public RouteLocator locateOrderServiceRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(
                        routePredicate -> routePredicate.path("/order/**")
                                .uri("lb://order-service")
                ).build();
    }
}
