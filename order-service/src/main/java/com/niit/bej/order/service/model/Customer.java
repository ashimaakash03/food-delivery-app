package com.niit.bej.order.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

public class Customer {
    @MongoId
    private long id;
    private String fullName;
    private String email;
    private String contact;

    public Customer() {
    }

    public Customer(long id, String fullName, String email, String contact) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.contact = contact;
    }
}
