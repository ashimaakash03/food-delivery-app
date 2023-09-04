package com.niit.bej.order.service.service;

import com.niit.bej.order.service.exception.CustomerNotFoundException;
import com.niit.bej.order.service.exception.EmptyDatabaseException;
import com.niit.bej.order.service.exception.OrderNotFoundException;
import com.niit.bej.order.service.model.Address;
import com.niit.bej.order.service.model.Order;

import java.util.List;

public interface OrderService {
    Order addOrderForCustomer(String email, Order order) throws CustomerNotFoundException;

    Order findOrderByIdForCustomer(String email, long id) throws EmptyDatabaseException, OrderNotFoundException, CustomerNotFoundException;

    List<Order> findAllOrdersOfCustomer(String email) throws EmptyDatabaseException, CustomerNotFoundException;

    boolean removeOrderForCustomer(String email, long id) throws EmptyDatabaseException, OrderNotFoundException, CustomerNotFoundException;

    Address modifyDeliveryAddress(String email, long id, Address address) throws OrderNotFoundException, EmptyDatabaseException, CustomerNotFoundException;
}
