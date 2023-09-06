package com.niit.bej.customer.service.repository;

import com.niit.bej.customer.service.model.Address;
import com.niit.bej.customer.service.model.Customer;
import com.niit.bej.customer.service.model.Restaurant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;
    private Address address;
    private Restaurant restaurant;

    @BeforeEach
    void setUp() {
        customer = new Customer("", "", "", new ArrayList<>(), new ArrayList<>());
        address = new Address("", "", 0, "", "", 0);
        restaurant = new Restaurant(0, "", "", new ArrayList<>());
    }

    @AfterEach
    void tearDown() {
        customer = null;
        address = null;
        restaurant = null;
    }

    @Test
    @DisplayName("Test Case for saving new Customer")
    void givenCustomerToSaveShouldReturnCustomer() {
        this.customerRepository.save(customer);
        Customer customer1 = this.customerRepository.findById(customer.getEmail()).get();
        assertNotNull(customer1);
        assertEquals(customer.getEmail(), customer1.getEmail());
    }

    @Test
    @DisplayName("Test Case for deleting new Customer")
    void givenCustomerToSaveShouldDeleteCustomer() {
        customerRepository.insert(customer);
        Customer customer1 = customerRepository.findById(customer.getEmail()).get();
        customerRepository.delete(customer1);
        assertEquals(Optional.empty(), customerRepository.findById(customer.getEmail()));
    }

}
