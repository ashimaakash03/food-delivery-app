package com.niit.bej.customer.auth.service;

import com.niit.bej.customer.auth.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer registerCustomer(Customer customer) {
        return null;
    }

    @Override
    public boolean loginCustomer(Customer customer) {
        return false;
    }
}