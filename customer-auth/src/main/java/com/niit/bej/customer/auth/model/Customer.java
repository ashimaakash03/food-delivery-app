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
}
