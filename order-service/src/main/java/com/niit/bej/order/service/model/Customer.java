package com.niit.bej.order.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

public class Customer {
    private String fullName;
    @MongoId
    private String email;
    private String contact;

    public Customer() {
    }

    public Customer(String fullName, String email, String contact) {
        this.fullName = fullName;
        this.email = email;
        this.contact = contact;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(fullName, customer.fullName) && Objects.equals(email, customer.email) && Objects.equals(contact, customer.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, email, contact);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
