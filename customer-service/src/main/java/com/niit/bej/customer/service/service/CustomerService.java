package com.niit.bej.customer.service.service;

import com.niit.bej.customer.service.exception.*;
import com.niit.bej.customer.service.model.Customer;
import com.niit.bej.customer.service.model.Restaurant;

import java.util.List;

public interface CustomerService {
    Customer registerCustomer(Customer customer) throws CustomerAlreadyPresentException;

    Restaurant addRestaurantUnderUser(Restaurant restaurant, String email) throws CustomerNotFoundException, RestaurantAlreadyPresentException;

    boolean removeRestaurantForUser(long id, String email) throws RestaurantNotFoundException, CustomerNotFoundException, EmptyDatabaseException;

    Restaurant viewRestaurantUnderUser(long id, String email) throws RestaurantNotFoundException, CustomerNotFoundException, EmptyDatabaseException;

    List<Restaurant> viewAllRestaurantsUnderUser(String email) throws EmptyDatabaseException, CustomerNotFoundException;

    Customer updateCustomerDetails(Customer customer, String email) throws CustomerNotFoundException;

    Customer fetchACustomer(String email) throws CustomerNotFoundException;

    List<Customer> fetchAllCustomers() throws EmptyDatabaseException;

    boolean deleteCustomer(String email) throws CustomerNotFoundException;
}
