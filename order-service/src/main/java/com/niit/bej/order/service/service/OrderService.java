package com.niit.bej.order.service.service;

import com.niit.bej.order.service.exception.CustomerNotFoundException;
import com.niit.bej.order.service.exception.OrderNotFoundException;
import com.niit.bej.order.service.model.Address;
import com.niit.bej.order.service.model.Order;

import java.util.List;

public interface OrderService {
    Order addOrderForCustomer(String email, Order order) throws CustomerNotFoundException;

    Order findOrderByIdForCustomer(String email, long id) throws OrderNotFoundException, CustomerNotFoundException;

    List<Order> findAllOrdersOfCustomer(String email);

    Order updateOrderOfCustomer(String email, Order order);

    boolean removeOrderForCustomer(String email, long id);

    Address modifyDeliveryAddress(String email, Address address);
}
