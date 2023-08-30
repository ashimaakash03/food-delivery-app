package com.niit.bej.customer.service.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
public class Customer {
    private String fullname;
    private String contact;
    @MongoId
    private String email;
    private List<Address> addresses;
    private List<Restaurant> restaurants;

    public Customer() {
    }

    public Customer(String fullname, String contact, String email, List<Address> addresses, List<Restaurant> restaurants) {
        this.fullname = fullname;
        this.contact = contact;
        this.email = email;
        this.addresses = addresses;
        this.restaurants = restaurants;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
