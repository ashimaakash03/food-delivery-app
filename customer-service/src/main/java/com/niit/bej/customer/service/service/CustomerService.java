package com.niit.bej.customer.service.service;

import com.niit.bej.customer.service.exception.*;
import com.niit.bej.customer.service.model.Address;
import com.niit.bej.customer.service.model.Customer;
import com.niit.bej.customer.service.model.Restaurant;

import java.util.List;

public interface CustomerService {
    Customer registerCustomer(Customer customer) throws CustomerAlreadyPresentException;

    Restaurant addRestaurantUnderCustomer(Restaurant restaurant, String email) throws CustomerNotFoundException, RestaurantAlreadyPresentException;

    boolean removeRestaurantForCustomer(long id, String email) throws RestaurantNotFoundException, CustomerNotFoundException, EmptyDatabaseException;

    Restaurant viewRestaurantUnderCustomer(long id, String email) throws RestaurantNotFoundException, CustomerNotFoundException, EmptyDatabaseException;

    List<Restaurant> viewAllRestaurantsUnderCustomer(String email) throws EmptyDatabaseException, CustomerNotFoundException;

    Restaurant updateSingleRestaurantForCustomer(Restaurant restaurant, String email) throws EmptyDatabaseException, CustomerNotFoundException, RestaurantNotFoundException;
    Customer updateCustomerDetails(Customer customer, String email) throws CustomerNotFoundException;

    Customer fetchACustomer(String email) throws CustomerNotFoundException;

    List<Customer> fetchAllCustomers() throws EmptyDatabaseException;

    boolean deleteCustomer(String email) throws CustomerNotFoundException;

    Address addAddressForCustomer(Address address, String email) throws CustomerNotFoundException;

    Address getSingleAddressForCustomer(String flatDetails, String email) throws EmptyDatabaseException, AddressNotFoundException, CustomerNotFoundException;

    List<Address> getAllAddressesForCustomer(String email) throws EmptyDatabaseException, CustomerNotFoundException;

    Address updateSingleAddressForCustomer(Address address, String email) throws EmptyDatabaseException, CustomerNotFoundException, AddressNotFoundException;

    boolean deleteSingleAddressForCustomer(String flatDetails, String email) throws EmptyDatabaseException, AddressNotFoundException, CustomerNotFoundException;
}
