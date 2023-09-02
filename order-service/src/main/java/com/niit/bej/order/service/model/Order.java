package com.niit.bej.order.service.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "orders")
public class Order {
    @MongoId
    private long id;
    private Customer customer;
    private Address deliveryAddress;
    private List<Restaurant> restaurant;

    public Order() {
    }

    public Order(long id, Customer customer, Address deliveryAddress, List<Restaurant> restaurant) {
        this.id = id;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.restaurant = restaurant;
    }
}
