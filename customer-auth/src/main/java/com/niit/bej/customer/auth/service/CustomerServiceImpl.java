package com.niit.bej.customer.auth.service;

import com.niit.bej.customer.auth.model.Customer;
import com.niit.bej.customer.auth.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer registerCustomer(Customer customer) {
        return null;
    }

    @Override
    public boolean loginCustomer(Customer customer) {
        return false;
    }
}
