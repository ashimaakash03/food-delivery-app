package com.niit.bej.customer.service.controller;

import com.niit.bej.customer.service.exception.CustomerAlreadyPresentException;
import com.niit.bej.customer.service.exception.CustomerNotFoundException;
import com.niit.bej.customer.service.exception.EmptyDatabaseException;
import com.niit.bej.customer.service.model.Customer;
import com.niit.bej.customer.service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        try {
            Customer newCustomer = this.customerService.registerCustomer(customer);
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        } catch (CustomerAlreadyPresentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<?> fetchCustomerByEmail(@PathVariable String email) {
        try {
            Customer requiredCustomer = this.customerService.fetchACustomer(email);
            return new ResponseEntity<>(requiredCustomer, HttpStatus.FOUND);
        } catch (CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> fetchAllCustomersList() {
        try {
            List<Customer> allCustomers = this.customerService.fetchAllCustomers();
            return new ResponseEntity<>(allCustomers, HttpStatus.FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/update/{email}")
    public ResponseEntity<?> updateCustomerByEmail(@RequestBody Customer customer, @PathVariable String email) {
        try {
            Customer updatedCustomer = this.customerService.updateCustomerDetails(customer, email);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } catch (CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<?> deleteCustomerByEmail(@PathVariable String email) {
        try {
            this.customerService.deleteCustomer(email);
            return new ResponseEntity<>("Customer with Email: " + email + " deleted", HttpStatus.OK);
        } catch (CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
