package com.niit.bej.customer.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "customer-auth-service")
public interface CustomerProxy {
}
