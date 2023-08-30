package com.niit.bej.customer.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

public class MenuItem {
    @MongoId
    private long id;
    private String name;
    private String category;
    private float price;

    public MenuItem() {
    }

    public MenuItem(long id, String name, String category, float price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
