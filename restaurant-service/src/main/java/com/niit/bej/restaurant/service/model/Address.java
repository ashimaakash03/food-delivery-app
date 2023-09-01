package com.niit.bej.restaurant.service.model;

public class Address {
    private int houseNumber;
    private String roadName, city;
    private Long postcode;

    public Address() {
    }

    public Address(int houseNumber, String roadName, String city, Long postcode) {
        this.houseNumber = houseNumber;
        this.roadName = roadName;
        this.city = city;
        this.postcode = postcode;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPostcode() {
        return postcode;
    }

    public void setPostcode(Long postcode) {
        this.postcode = postcode;
    }

}
