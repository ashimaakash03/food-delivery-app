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
@LoadBalancerClient(name = "customer-auth-service")
public class CustomerAuthRouteConfig {
    @Bean
    @LoadBalanced
    public RouteLocator locateCustomerAuthMicroserviceRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(
                        routePredicate -> routePredicate.path("/home/**")
                                .uri("lb://customer-auth-service")
                ).build();
    }
}
