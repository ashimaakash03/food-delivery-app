package com.niit.bej.order.service.service;

import com.niit.bej.order.service.model.Address;
import com.niit.bej.order.service.model.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public Order addOrderForCustomer(String email, Order order) {
        return null;
    }

    @Override
    public Order findOrderByIdForCustomer(String email, long id) {
        return null;
    }

    @Override
    public List<Order> findAllOrdersOfCustomer(String email) {
        return null;
    }

    @Override
    public Order updateOrderOfCustomer(String email, Order order) {
        return null;
    }

    @Override
    public boolean removeOrderForCustomer(String email, long id) {
        return false;
    }

    @Override
    public Address modifyDeliveryAddress(String email, Address address) {
        return null;
    }
}
