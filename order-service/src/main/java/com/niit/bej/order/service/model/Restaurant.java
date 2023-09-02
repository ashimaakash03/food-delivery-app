package com.niit.bej.order.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

public class Restaurant {
    @MongoId
    private long id;
    private String name;
    private String city;
    private List<Item> order;
}
