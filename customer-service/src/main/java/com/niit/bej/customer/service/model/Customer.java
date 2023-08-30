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


}
