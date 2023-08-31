package com.niit.bej.customer.service.controller;

import com.niit.bej.customer.service.exception.*;
import com.niit.bej.customer.service.model.Customer;
import com.niit.bej.customer.service.model.Restaurant;
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

    @PostMapping("/add/{email}")
    public ResponseEntity<?> addRestaurantForCustomer(@RequestBody Restaurant restaurant, @PathVariable String email) {
        try {
            Restaurant addedRestaurant = this.customerService.addRestaurantUnderCustomer(restaurant, email);
            return new ResponseEntity<>(addedRestaurant, HttpStatus.CREATED);
        } catch (CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } catch (RestaurantAlreadyPresentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/view/{email}/{id}")
    public ResponseEntity<?> fetchRestaurantUnderCustomerById(@PathVariable long id, @PathVariable String email) {
        try {
            Restaurant requestedRestaurant = this.customerService.viewRestaurantUnderCustomer(id, email);
            return new ResponseEntity<>(requestedRestaurant, HttpStatus.FOUND);
        } catch (RestaurantNotFoundException | CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/view/all/{email}")
    public ResponseEntity<?> fetchAllRestaurantsUnderCustomer(@PathVariable String email) {
        try {
            List<Restaurant> restaurantList = this.customerService.viewAllRestaurantsUnderCustomer(email);
            return new ResponseEntity<>(restaurantList, HttpStatus.FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{email}")
    public ResponseEntity<?> updateRestaurantForCustomerById(@RequestBody Restaurant restaurant, @PathVariable String email) {
        try {
            Restaurant updatedRestaurant = this.customerService.updateSingleRestaurantForCustomer(restaurant, email);
            return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException | RestaurantNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{email}/{id}")
    public ResponseEntity<?> deleteRestaurantForCustomerById(@PathVariable String email, @PathVariable long id) {
        try {
            this.customerService.removeRestaurantForCustomer(id, email);
            return new ResponseEntity<>("Restaurant with ID: " + id + " deleted for customer with Email: " + email, HttpStatus.OK);
        } catch (RestaurantNotFoundException | CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
    }
}
