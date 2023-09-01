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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
