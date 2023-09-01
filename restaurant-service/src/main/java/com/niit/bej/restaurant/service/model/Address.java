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

}
