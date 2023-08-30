package com.niit.bej.customer.auth.security;

import com.niit.bej.customer.auth.model.Customer;

import java.util.Map;

public class JwtSecurityTokenGenerator implements SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(Customer customer) {
        return null;
    }
}
