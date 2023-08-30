package com.niit.bej.customer.auth.service;

import com.niit.bej.customer.auth.exception.CustomerAlreadyExistsException;
import com.niit.bej.customer.auth.exception.CustomerNotFoundException;
import com.niit.bej.customer.auth.exception.InvalidCredentialsException;
import com.niit.bej.customer.auth.model.Customer;

public interface CustomerService {
    Customer registerCustomer(Customer customer) throws CustomerAlreadyExistsException;

    boolean loginCustomer(Customer customer) throws InvalidCredentialsException, CustomerNotFoundException;
}
