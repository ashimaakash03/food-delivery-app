package com.niit.bej.api.gateway.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@LoadBalancerClient
public class OrderServiceRouteConfig {

}
