package com.niit.bej.customer.service.controller;

import com.niit.bej.customer.service.exception.*;
import com.niit.bej.customer.service.model.Address;
import com.niit.bej.customer.service.model.Customer;
import com.niit.bej.customer.service.model.Restaurant;
import com.niit.bej.customer.service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
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

    @PostMapping("/add-restaurant/{email}")
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

    @GetMapping("/view-restaurant/{email}/{id}")
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

    @GetMapping("/view-restaurant/all/{email}")
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

    @PutMapping("/update-restaurant/{email}")
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

    @DeleteMapping("/delete-restaurant/{email}/{id}")
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

    @PostMapping("/add-address/{email}")
    public ResponseEntity<?> addAddressForCustomer(@RequestBody Address address, @PathVariable String email) {
        try {
            Address newlyAddedAddress = this.customerService.addAddressForCustomer(address, email);
            return new ResponseEntity<>(newlyAddedAddress, HttpStatus.CREATED);
        } catch (CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } catch (AddressAlreadyPresentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/view-address/{email}/{flatDetails}")
    public ResponseEntity<?> viewAddressForCustomerById(@PathVariable String email, @PathVariable String flatDetails) {
        try {
            Address requestedAddress = this.customerService.getSingleAddressForCustomer(email, flatDetails);
            return new ResponseEntity<>(requestedAddress, HttpStatus.FOUND);
        } catch (AddressNotFoundException | CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/view-address/all/{email}")
    public ResponseEntity<?> viewAllAddressesListUnderCustomer(@PathVariable String email) {
        try {
            List<Address> addressList = this.customerService.getAllAddressesForCustomer(email);
            return new ResponseEntity<>(addressList, HttpStatus.FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-address/{email}")
    public ResponseEntity<?> updateAddressForCustomerById(@RequestBody Address address, @PathVariable String email) {
        try {
            Address updatedAddress = this.customerService.updateSingleAddressForCustomer(address, email);
            return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
        } catch (AddressNotFoundException | CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/delete-address/{email}/{flatDetails}")
    public ResponseEntity<?> deleteAddressForCustomerById(@PathVariable String email, @PathVariable String flatDetails) {
        try {
            this.customerService.deleteSingleAddressForCustomer(email, flatDetails);
            return new ResponseEntity<>("Address with Flat Number: " + flatDetails + " deleted for customer with Email: " + email, HttpStatus.OK);
        } catch (AddressNotFoundException | CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
    }
}
