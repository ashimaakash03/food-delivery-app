package com.niit.bej.customer.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

public class Restaurant {
    @MongoId
    private long id;
    private String name;
    private String locationCity;
    private List<MenuItem> orders;

    public Restaurant() {
    }

    public Restaurant(long id, String name, String locationCity, List<MenuItem> orders) {
        this.id = id;
        this.name = name;
        this.locationCity = locationCity;
        this.orders = orders;
    }


}
