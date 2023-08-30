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

    public String getFlatDetails() {
        return flatDetails;
    }

    public void setFlatDetails(String flatDetails) {
        this.flatDetails = flatDetails;
    }

    public String getSoceityName() {
        return soceityName;
    }

    public void setSoceityName(String soceityName) {
        this.soceityName = soceityName;
    }

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }
}
