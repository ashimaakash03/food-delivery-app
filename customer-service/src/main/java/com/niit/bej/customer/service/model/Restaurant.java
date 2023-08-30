package com.niit.bej.customer.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

public class Restaurant {
    @MongoId
    private long id;
    private String name;
    private String locationCity;

}
