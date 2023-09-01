package com.niit.bej.customer.auth.security;

import com.niit.bej.customer.auth.model.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class JwtSecurityTokenGenerator implements SecurityTokenGenerator {
    public static final int SECONDS = 60;
    public static final int MINUTES = 60;
    public static final int DURATION = 10;
    public static final int MILLISECOND = 1000;
    @Override
    public Map<String, String> generateToken(Customer customer) {
        String jwtToken = Jwts.builder().setIssuedAt(new Date())
                .setSubject(customer.getFullname()).signWith(SignatureAlgorithm.HS256, "password")
                .compact();

        return Map.of("token", jwtToken,
                "message", customer.getFullname() + " logged in");
    }
}
