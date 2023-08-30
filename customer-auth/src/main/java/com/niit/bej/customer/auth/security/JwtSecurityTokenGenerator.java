package com.niit.bej.customer.auth.security;

import com.niit.bej.customer.auth.model.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtSecurityTokenGenerator implements SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(Customer customer) {
        String jwtToken = Jwts.builder().setIssuedAt(new Date())
                .setSubject(customer.getFullname()).signWith(SignatureAlgorithm.HS256, "password")
                .compact();

        return Map.of("token", jwtToken,
                "message", customer.getFullname() + " logged in");
    }
}
