package com.niit.bej.order.service.repository;


import com.niit.bej.order.service.model.Address;
import com.niit.bej.order.service.model.Customer;
import com.niit.bej.order.service.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {
    Optional<Customer> findCustomerByEmail(String email);
    List<Order> findAllOrdersByCustomer(String email);

    Address changeDeliveryAddress(Address address);
}
