package com.niit.bej.order.service.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.Objects;

@Document(collection = "orders")
public class Order {
    @MongoId
    private long id;
    private Customer customer;
    private Address deliveryAddress;
    private List<Restaurant> restaurants;

    public Order() {
    }

    public Order(long id, Customer customer, Address deliveryAddress, List<Restaurant> restaurants) {
        this.id = id;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.restaurants = restaurants;
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

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurant(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(customer, order.customer) && Objects.equals(deliveryAddress, order.deliveryAddress) && Objects.equals(restaurants, order.restaurants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, deliveryAddress, restaurants);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", deliveryAddress=" + deliveryAddress +
                ", restaurants=" + restaurants +
                '}';
    }
}
