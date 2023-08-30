package com.niit.bej.customer.auth.controller;

import com.niit.bej.customer.auth.exception.CustomerAlreadyExistsException;
import com.niit.bej.customer.auth.exception.CustomerNotFoundException;
import com.niit.bej.customer.auth.exception.InvalidCredentialsException;
import com.niit.bej.customer.auth.model.Customer;
import com.niit.bej.customer.auth.security.SecurityTokenGenerator;
import com.niit.bej.customer.auth.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        try {
            Customer registeredCustomer = this.customerService.registerCustomer(customer);
            return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
        } catch (CustomerAlreadyExistsException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(Customer customer) {
        try {
            boolean isCustomerLoggedIn = this.customerService.loginCustomer(customer);
            if (isCustomerLoggedIn) {
                Map<String, String> generatedToken = this.securityTokenGenerator.generateToken(customer);
                return new ResponseEntity<>(generatedToken, HttpStatus.OK);
            } else {
                throw new InvalidCredentialsException("Incorrect Email And Password Combination");
            }
        } catch (InvalidCredentialsException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
        } catch (CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
