package com.niit.bej.order.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

public class Item {
    @MongoId
    private long id;
    private String name;
    private String category;
    private double price;

    public Item() {
    }

    public Item(long id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
