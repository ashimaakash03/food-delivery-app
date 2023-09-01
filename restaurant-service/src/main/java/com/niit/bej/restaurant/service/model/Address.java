package com.niit.bej.restaurant.service.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (houseNumber != address.houseNumber) return false;
        if (!Objects.equals(roadName, address.roadName)) return false;
        if (!Objects.equals(city, address.city)) return false;
        return Objects.equals(postcode, address.postcode);
    }

    @Override
    public int hashCode() {
        int result = houseNumber;
        result = 31 * result + (roadName != null ? roadName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber=" + houseNumber +
                ", roadName='" + roadName + '\'' +
                ", city='" + city + '\'' +
                ", postcode=" + postcode +
                '}';
    }
}
