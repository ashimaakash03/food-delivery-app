package com.niit.bej.customer.service.model;


import org.springframework.data.mongodb.core.mapping.MongoId;

public class Address {
    @MongoId
    private String flatDetails;
    private String soceityName;
    private int sector;
    private String cityName;
    private String stateName;
    private long pincode;
}
