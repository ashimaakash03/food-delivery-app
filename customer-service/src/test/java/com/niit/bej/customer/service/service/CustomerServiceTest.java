package com.niit.bej.customer.service.service;

import com.niit.bej.customer.service.exception.CustomerAlreadyPresentException;
import com.niit.bej.customer.service.model.Address;
import com.niit.bej.customer.service.model.Customer;
import com.niit.bej.customer.service.model.Restaurant;
import com.niit.bej.customer.service.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;

    private Customer customer;
    private Address address;
    private Restaurant restaurant;

    @BeforeEach
    void setUp() {
        Address address1 = new Address("J-2301", "Maxblis Whitehouse", 75, "Noida", "uttar Pradesh", 201301);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        Restaurant restaurant1 = new Restaurant(101, "Bhojan-Aalay", "Noida", new ArrayList<>());
        List<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.add(restaurant1);
        Address address2 = new Address("E-701", "Mahagun Maple", 50, "Noida", "uttar Pradesh", 201301);
        addressList.add(address2);
        Restaurant restaurant2 = new Restaurant(103, "Aahaar-Bhavan", "Noida", new ArrayList<>());
        restaurantList.add(restaurant2);
        Customer customer1 = new Customer("Ashim", "9154472559", "ashimaakash1997@gmail.com", addressList, restaurantList);
    }

    @AfterEach
    void tearDown() {
        customer = null;
        address = null;
        restaurant = null;
    }

    @Test
    void givenCustomerToSaveReturnSavedCustomerSuccess() throws CustomerAlreadyPresentException {
        when(customerRepository.findById(customer.getEmail())).thenReturn(Optional.ofNullable(null));
        when(this.customerRepository.save(customer)).thenReturn(customer);
        assertEquals(customer, this.customerServiceImpl.registerCustomer(customer));
    }

    @Test
    void givenCustomerToSaveReturnSavedCustomerFailure() {
        when(customerRepository.findById(customer.getEmail())).thenReturn(Optional.ofNullable(customer));
        assertThrows(CustomerAlreadyPresentException.class, () -> customerServiceImpl.registerCustomer(customer));
    }
}
