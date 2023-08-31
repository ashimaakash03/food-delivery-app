package com.niit.bej.customer.service.proxy;

import com.niit.bej.customer.service.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "customer-auth-service")
public interface CustomerProxy {
    @PostMapping(value = "/api/v1/auth/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer);
}
