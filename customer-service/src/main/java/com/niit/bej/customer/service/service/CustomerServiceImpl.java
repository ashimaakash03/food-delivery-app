package com.niit.bej.customer.service.service;

import com.niit.bej.customer.service.exception.*;
import com.niit.bej.customer.service.model.Customer;
import com.niit.bej.customer.service.model.Restaurant;
import com.niit.bej.customer.service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer registerCustomer(Customer customer) throws CustomerAlreadyPresentException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(customer.getEmail());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyPresentException("Customer with Email: " + customer.getEmail() + " already present");
        } else {
            return this.customerRepository.save(customer);
        }
    }

    @Override
    public Restaurant addRestaurantUnderCustomer(Restaurant restaurant, String email) throws CustomerNotFoundException, RestaurantAlreadyPresentException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            List<Restaurant> restaurantList = customerInDatabase.getRestaurants();
            if (restaurantList.contains(restaurant)) {
                throw new RestaurantAlreadyPresentException("Restaurant Already Present");
            } else {
                restaurantList.add(restaurant);
                return restaurant;
            }
        } else {
            throw new CustomerNotFoundException("Customer with Email: " + email + " not present");
        }
    }

    @Override
    public boolean removeRestaurantForCustomer(long id, String email) throws RestaurantNotFoundException, CustomerNotFoundException, EmptyDatabaseException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            List<Restaurant> restaurantList = customerInDatabase.getRestaurants();
            if (restaurantList.isEmpty()) {
                throw new EmptyDatabaseException("No restaurants found under the user bearing email: " + email);
            } else {
                boolean isRestaurantRemoved = false;
                for (Restaurant restaurant : restaurantList) {
                    if (restaurant.getId() == id) {
                        isRestaurantRemoved = restaurantList.remove(restaurant);
                    } else {
                        throw new RestaurantNotFoundException("Restaurant with ID: " + id + " not found");
                    }
                }
                return isRestaurantRemoved;
            }
        } else {
            throw new CustomerNotFoundException("Customer with Email: " + email + " not present");
        }
    }

    @Override
    public Restaurant viewRestaurantUnderCustomer(long id, String email) throws RestaurantNotFoundException, CustomerNotFoundException, EmptyDatabaseException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            List<Restaurant> restaurantList = customerInDatabase.getRestaurants();
            if (restaurantList.isEmpty()) {
                throw new EmptyDatabaseException("No restaurants found under the user bearing email: " + email);
            } else {
                Restaurant searchedRestaurant = null;
                for (Restaurant restaurant : restaurantList) {
                    if (restaurant.getId() == id) {
                        searchedRestaurant = restaurant;
                    } else {
                        throw new RestaurantNotFoundException("Restaurant with ID: " + id + " not found");
                    }
                }
                return searchedRestaurant;
            }
        } else {
            throw new CustomerNotFoundException("Customer with Email: " + email + " not present");
        }
    }

    @Override
    public List<Restaurant> viewAllRestaurantsUnderCustomer(String email) throws EmptyDatabaseException, CustomerNotFoundException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            List<Restaurant> restaurantList = customerInDatabase.getRestaurants();
            if (restaurantList.isEmpty()) {
                throw new EmptyDatabaseException("No Restaurants found under the user");
            } else {
                return restaurantList;
            }
        } else {
            throw new CustomerNotFoundException("Customer with Email: " + email + " not present");
        }
    }

    @Override
    public Customer updateCustomerDetails(Customer customer, String email) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();

            customerInDatabase.setFullname(customer.getFullname());
            customerInDatabase.setContact(customer.getContact());
            customerInDatabase.setEmail(customer.getEmail());

            return this.customerRepository.save(customerInDatabase);
        } else {
            throw new CustomerNotFoundException("Customer with Email: " + email + " not present");
        }
    }

    @Override
    public Customer fetchACustomer(String email) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(email);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            throw new CustomerNotFoundException("Customer with Email: " + email + " not present");
        }
    }

    @Override
    public List<Customer> fetchAllCustomers() throws EmptyDatabaseException {
        List<Customer> allCustomersList = this.customerRepository.findAll();
        if (allCustomersList.isEmpty()) {
            throw new EmptyDatabaseException("No Customers Found In Database");
        } else {
            return allCustomersList;
        }
    }

    @Override
    public boolean deleteCustomer(String email) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            this.customerRepository.delete(customerInDatabase);
            return true;
        } else {
            throw new CustomerNotFoundException("Customer with Email: " + email + " not present");
        }
    }
}
