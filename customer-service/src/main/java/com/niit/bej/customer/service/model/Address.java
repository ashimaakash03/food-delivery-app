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

    public Address() {
    }

    public Address(String flatDetails, String soceityName, int sector, String cityName, String stateName, long pincode) {
        this.flatDetails = flatDetails;
        this.soceityName = soceityName;
        this.sector = sector;
        this.cityName = cityName;
        this.stateName = stateName;
        this.pincode = pincode;
    }
}
