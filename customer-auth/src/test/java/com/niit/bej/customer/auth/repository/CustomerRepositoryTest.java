//package com.niit.bej.customer.auth.repository;
//
//import com.niit.bej.customer.auth.model.Customer;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@DataJpaTest
//public class CustomerRepositoryTest {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//    private Customer customer;
//
//    @BeforeEach
//    void setUp() {
//        customer = new Customer();
//        customer.setFullname("Ashutosh");
//        customer.setContact("7349369484")
//        customer.setEmail("ashutosh.k.work@gmail.com");
//        customer.setPassword("ashutosh");
//    }
//
//    @AfterEach
//    void tearDown() {
//        customer = null;
//        customerRepository.deleteAll();
//    }
//
//    @Test
//    void customerRepositoryTest_save_shouldReturnSavedCustomer() {
//        Customer savedCustomer = customerRepository.save(customer);
//        assertThat(savedCustomer).isNotNull();
//        assertEquals(savedCustomer.getEmail(), customer.getEmail());
//    }
//}
