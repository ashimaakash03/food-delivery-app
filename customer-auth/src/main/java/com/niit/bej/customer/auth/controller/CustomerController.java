package com.niit.bej.customer.auth.controller;

import com.niit.bej.customer.auth.security.SecurityTokenGenerator;
import com.niit.bej.customer.auth.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class CustomerController {
    private final CustomerService customerService;
    private final SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public CustomerController(CustomerService customerService, SecurityTokenGenerator securityTokenGenerator) {
        this.customerService = customerService;
        this.securityTokenGenerator = securityTokenGenerator;
    }
}
