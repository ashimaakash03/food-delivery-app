package com.niit.bej.customer.service.service;

import com.niit.bej.customer.service.model.Customer;
import com.niit.bej.customer.service.model.Restaurant;
import com.niit.bej.customer.service.proxy.CustomerProxy;
import com.niit.bej.customer.service.repository.CustomerRepository;
import com.niit.bej.customer.service.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;
    private final CustomerProxy customerProxy;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, RestaurantRepository restaurantRepository, CustomerProxy customerProxy) {
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
        this.customerProxy = customerProxy;
    }

    @Override
    public Customer registerCustomer(Customer customer) {
        return null;
    }

    @Override
    public Restaurant addRestaurantUnderUser(Restaurant restaurant, String email) {
        return null;
    }

    @Override
    public Restaurant removeRestaurantForUser(long id, String email) {
        return null;
    }

    @Override
    public Restaurant viewRestaurantUnderUser(long id, String email) {
        return null;
    }

    @Override
    public List<Restaurant> viewAllRestaurantsUnderUser(String email) {
        return null;
    }

    @Override
    public boolean deleteRestaurantUnderUser(long id, String email) {
        return false;
    }

    @Override
    public Customer updateCustomerDetails(Customer customer, String email) {
        return null;
    }

    @Override
    public Customer fetchACustomer(String email) {
        return null;
    }

    @Override
    public List<Customer> fetchAllCustomers() {
        return null;
    }

    @Override
    public boolean deleteUser(String email) {
        return false;
    }
}
