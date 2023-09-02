package com.niit.bej.order.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return sector == address.sector && pincode == address.pincode && Objects.equals(flatDetails, address.flatDetails) && Objects.equals(soceityName, address.soceityName) && Objects.equals(cityName, address.cityName) && Objects.equals(stateName, address.stateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flatDetails, soceityName, sector, cityName, stateName, pincode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "flatDetails='" + flatDetails + '\'' +
                ", soceityName='" + soceityName + '\'' +
                ", sector=" + sector +
                ", cityName='" + cityName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
