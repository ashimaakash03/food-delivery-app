package com.niit.bej.customer.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

public class MenuItem {
    @MongoId
    private long id;
    private String name;
    private String category;
    private float price;
}
