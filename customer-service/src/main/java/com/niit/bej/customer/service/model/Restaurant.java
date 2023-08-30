package com.niit.bej.customer.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

public class Restaurant {
    @MongoId
    private long id;
    private String name;
    private String locationCity;
    private List<MenuItem> orders;
}
