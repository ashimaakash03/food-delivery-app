package com.niit.bej.order.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

public class Restaurant {
    @MongoId
    private long id;
    private String name;
    private String city;
    private List<Item> order;

    public Restaurant() {
    }

    public Restaurant(long id, String name, String city, List<Item> order) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.order = order;
    }
}
