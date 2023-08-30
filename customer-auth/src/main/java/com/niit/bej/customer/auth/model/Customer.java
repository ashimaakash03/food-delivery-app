package com.niit.bej.customer.auth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "zwigato_users")
public class Customer {
    @Column(name = "full_name", nullable = false)
    private String fullname;
    @Column(name = "contact", length = 10, unique = true, nullable = false)
    private String contact;
    @Id
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", length = 25, unique = true, nullable = false)
    private String password;

    public Customer() {
    }

    public Customer(String fullname, String contact, String email, String password) {
        this.fullname = fullname;
        this.contact = contact;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
