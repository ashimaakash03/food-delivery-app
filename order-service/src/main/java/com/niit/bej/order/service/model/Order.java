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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<Restaurant> getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(List<Restaurant> restaurant) {
        this.restaurant = restaurant;
    }
}
