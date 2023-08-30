package com.niit.bej.customer.auth.security;

import com.niit.bej.customer.auth.model.Customer;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String, String> generateToken(Customer customer);
}
