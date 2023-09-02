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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
