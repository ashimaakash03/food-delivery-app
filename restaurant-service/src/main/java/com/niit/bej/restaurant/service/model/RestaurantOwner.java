package com.niit.bej.restaurant.service.model;

import java.util.List;

public class RestaurantOwner {
    private String email;
    private String password;
    private String ownerName;
    private String phoneNumber;
    private String gstNumber;
    private List<Address> address;

    public RestaurantOwner() {
    }

    public RestaurantOwner(String email, String password, String ownerName, String phoneNumber, String gstNumber, List<Address> address) {
        this.email = email;
        this.password = password;
        this.ownerName = ownerName;
        this.phoneNumber = phoneNumber;
        this.gstNumber = gstNumber;
        this.address = address;
    }

}
