package com.niit.bej.customer.service.service;

import com.niit.bej.customer.service.exception.*;
import com.niit.bej.customer.service.model.Address;
import com.niit.bej.customer.service.model.Customer;
import com.niit.bej.customer.service.model.Restaurant;
import com.niit.bej.customer.service.repository.AddressRepository;
import com.niit.bej.customer.service.repository.CustomerRepository;
import com.niit.bej.customer.service.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository, RestaurantRepository restaurantRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.restaurantRepository = restaurantRepository;
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
    public Restaurant updateSingleRestaurantForCustomer(Restaurant restaurant, String email) throws EmptyDatabaseException, CustomerNotFoundException, RestaurantNotFoundException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            List<Restaurant> restaurantList = customerInDatabase.getRestaurants();
            if (restaurantList.isEmpty()) {
                throw new EmptyDatabaseException("No restaurants found under customer with email: " + email);
            } else {
                Restaurant restaurantToBeUpdated = null;
                for (Restaurant restaurant1 : restaurantList) {
                    if (restaurant1.getId() == restaurant.getId()) {
                        restaurantToBeUpdated = restaurant1;
                        restaurantToBeUpdated.setName(restaurant.getName());
                        restaurantToBeUpdated.setLocationCity(restaurant.getLocationCity());


                    } else {
                        throw new RestaurantNotFoundException("Restaurant with ID: " + restaurant.getId() + " not found");
                    }
                }
                return this.restaurantRepository.save(restaurantToBeUpdated);
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

    @Override
    public Address addAddressForCustomer(Address address, String email) throws CustomerNotFoundException, AddressAlreadyPresentException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            List<Address> addressList = customerInDatabase.getAddresses();
            if (addressList.contains(address)) {
                throw new AddressAlreadyPresentException("Address already present in the list");
            }
            addressList.add(address);
            return address;
        } else {
            throw new CustomerNotFoundException("Customer with Email: " + email + " not present");
        }
    }

    @Override
    public Address getSingleAddressForCustomer(String flatDetails, String email) throws EmptyDatabaseException, AddressNotFoundException, CustomerNotFoundException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            List<Address> addressList = customerInDatabase.getAddresses();
            if (addressList.isEmpty()) {
                throw new EmptyDatabaseException("No addresses found under customer with email: " + email);
            } else {
                Address searchedAddress = null;
                for (Address address : addressList) {
                    if (address.getFlatDetails().equals(flatDetails)) {
                        searchedAddress = address;
                    } else {
                        throw new AddressNotFoundException("Address beginning with Flat Details: " + flatDetails + " not found");
                    }
                }
                return searchedAddress;
            }
        } else {
            throw new CustomerNotFoundException("Customer with Email: " + email + " not present");
        }
    }

    @Override
    public List<Address> getAllAddressesForCustomer(String email) throws EmptyDatabaseException, CustomerNotFoundException {
        if (this.customerRepository.findById(email).isPresent()) {
            Customer customerInDatabase = this.customerRepository.findById(email).get();
            List<Address> addressList = customerInDatabase.getAddresses();
            if (addressList.isEmpty()) {
                throw new EmptyDatabaseException("No addresses found under customer with email: " + email);
            } else {
                return addressList;
            }
        } else {
            throw new CustomerNotFoundException("Customer with Email: " + email + " not present");
        }
    }

    @Override
    public Address updateSingleAddressForCustomer(Address address, String email) throws EmptyDatabaseException, CustomerNotFoundException, AddressNotFoundException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            List<Address> addressList = customerInDatabase.getAddresses();
            if (addressList.isEmpty()) {
                throw new EmptyDatabaseException("No addresses found under customer with email: " + email);
            } else {
                Address addressToBeUpdated = null;
                for (Address address1 : addressList) {
                    if (address1.getFlatDetails().equals(address.getFlatDetails())) {
                        addressToBeUpdated = address1;

                        addressToBeUpdated.setFlatDetails(address.getFlatDetails());
                        addressToBeUpdated.setSoceityName(address.getSoceityName());
                        addressToBeUpdated.setSector(address.getSector());
                        addressToBeUpdated.setCityName(address.getCityName());
                        addressToBeUpdated.setStateName(address.getStateName());
                        addressToBeUpdated.setPincode(address.getPincode());

                    } else {
                        throw new AddressNotFoundException("Address beginning with Flat Details: " + address.getFlatDetails() + " not found");
                    }
                }
                return this.addressRepository.save(addressToBeUpdated);
            }
        } else {
            throw new CustomerNotFoundException("Customer with Email: " + email + " not present");
        }
    }

    @Override
    public boolean deleteSingleAddressForCustomer(String flatDetails, String email) throws EmptyDatabaseException, AddressNotFoundException, CustomerNotFoundException {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            List<Address> addressList = customerInDatabase.getAddresses();
            if (addressList.isEmpty()) {
                throw new EmptyDatabaseException("No addresses found under customer with email: " + email);
            } else {
                boolean isAddressDeleted = false;
                for (Address address : addressList) {
                    if (address.getFlatDetails().equals(flatDetails)) {
                        isAddressDeleted = addressList.remove(address);
                    } else {
                        throw new AddressNotFoundException("Address beginning with Flat Details: " + address.getFlatDetails() + " not found");
                    }
                }
                return isAddressDeleted;
            }
        } else {
            throw new CustomerNotFoundException("Customer with Email: " + email + " not present");
        }
    }
}