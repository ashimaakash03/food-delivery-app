package com.niit.bej.customer.service.service;

import com.niit.bej.customer.service.model.Customer;
import com.niit.bej.customer.service.model.Restaurant;

import java.util.List;

public interface CustomerService {
    Customer registerCustomer(Customer customer);

    Restaurant addRestaurantUnderUser(Restaurant restaurant, String email);

    Restaurant removeRestaurantForUser(long id, String email);

    Restaurant viewRestaurantUnderUser(long id, String email);

    List<Restaurant> viewAllRestaurantsUnderUser(String email);

    boolean deleteRestaurantUnderUser(long id, String email);

    Customer updateCustomerDetails(Customer customer, String email);

    Customer fetchACustomer(String email);

    List<Customer> fetchAllCustomers();

    boolean deleteUser(String email);
}
