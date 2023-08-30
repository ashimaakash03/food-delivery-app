package com.niit.bej.customer.auth.service;

import com.niit.bej.customer.auth.model.Customer;

public interface CustomerService {
    Customer registerCustomer(Customer customer);

    boolean loginCustomer(Customer customer);
}
