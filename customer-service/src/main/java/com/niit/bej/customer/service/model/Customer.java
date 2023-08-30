package com.niit.bej.customer.service.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Customer {
    private String fullname;
    private String contact;
    @MongoId
    private String email;
}
