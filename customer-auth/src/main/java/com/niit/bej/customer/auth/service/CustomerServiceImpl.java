package com.niit.bej.customer.auth.service;

import com.niit.bej.customer.auth.exception.CustomerAlreadyExistsException;
import com.niit.bej.customer.auth.exception.CustomerNotFoundException;
import com.niit.bej.customer.auth.exception.InvalidCredentialsException;
import com.niit.bej.customer.auth.model.Customer;
import com.niit.bej.customer.auth.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer registerCustomer(Customer customer) throws CustomerAlreadyExistsException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(customer.getEmail());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer with Email: " + customer.getEmail() + " already present");
        } else {
            return this.customerRepository.save(customer);
        }
    }

    @Override
    public boolean loginCustomer(Customer customer) throws InvalidCredentialsException, CustomerNotFoundException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(customer.getEmail());
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            if (customerInDatabase.getEmail().equals(customer.getEmail()) && customerInDatabase.getPassword().equals(customer.getPassword())) {
                return true;
            } else {
                throw new InvalidCredentialsException("Incorrect Email and Password entered");
            }
        } else {
            throw new CustomerNotFoundException("Customer with Email: " + customer.getEmail() + " not present in database");
        }
    }
}
