package com.niit.bej.customer.auth.service;

import com.niit.bej.customer.auth.exception.CustomerAlreadyExistsException;
import com.niit.bej.customer.auth.model.Customer;
import com.niit.bej.customer.auth.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CustomerAuthServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("", "", "", "");
    }

    @AfterEach
    void tearDown() {
        customer = null;
    }

    @Test
    void givenCustomerToSaveReturnSavedCustomerSuccess() throws CustomerAlreadyExistsException {
        when(this.customerRepository.findById(customer.getEmail())).thenReturn(Optional.empty());
        when(this.customerRepository.save(customer)).thenReturn(customer);
        assertEquals(customer, this.customerServiceImpl.registerCustomer(customer));
    }

    @Test
    void givenCustomerToSaveReturnSavedCustomerFailure() {
        when(this.customerRepository.findById(customer.getEmail())).thenReturn(Optional.ofNullable(customer));
        assertThrows(CustomerAlreadyExistsException.class, () -> this.customerServiceImpl.registerCustomer(customer));
    }
}
