package com.niit.bej.customer.service.service;

import com.niit.bej.customer.service.model.Customer;
import com.niit.bej.customer.service.model.Restaurant;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
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
