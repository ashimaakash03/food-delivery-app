package com.niit.bej.order.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(fullName, customer.fullName) && Objects.equals(email, customer.email) && Objects.equals(contact, customer.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, contact);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
