package com.niit.bej.customer.auth.repository;

import com.niit.bej.customer.auth.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CustomerAuthRepositoryTest {
    private CustomerRepository customerRepository;
    private Customer customer;
//    @Autowired
//    public CustomerAuthRepositoryTest(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    @BeforeEach
    void setUp() {
        customer = new Customer("Ashim", "9154472559", "ashimaakash1997@gmail.com", "@Aakash1234");
    }

    @AfterEach
    void tearDown() {
        customer = null;
        customerRepository.deleteAll();
    }

    @Test
    @DisplayName("Test Case for saving a customer")
    void givenCustomerToSaveShouldReturnCustomer() {
        this.customerRepository.save(customer);
        Customer customer1 = this.customerRepository.findById(customer.getEmail()).get();
        assertNotNull(customer1);
        assertEquals(customer1.getEmail(), customer.getEmail());
    }

    @Test
    @DisplayName("Test Case for deleting a customer")
    void givenCustomerToDeleteShouldDeleteCustomer() {
        this.customerRepository.save(customer);
        Customer customer1 = this.customerRepository.findById(customer.getEmail()).get();
        this.customerRepository.delete(customer1);
        assertEquals(Optional.empty(), this.customerRepository.findById(customer.getEmail()));
    }

    @Test
    @DisplayName("Test Case for retrieving all customers")
    void shouldRetrieveAllCustomers() {
        this.customerRepository.save(customer);
        Customer customer1 = new Customer("Ashim", "9154472559", "ashimaakash1997@gmail.com", "@Ashim123");
        Customer customer2 = new Customer("Ashutosh", "7349369484", "ashutosh.k.work@gmail.com", "@Ashutosh1234");

        List<Customer> customerList = this.customerRepository.findAll();
        assertEquals(3, customerList.size());
        assertEquals("Ashim", customer1.getFullname());
        assertEquals("Ashutosh", customer2.getFullname());
    }
}
