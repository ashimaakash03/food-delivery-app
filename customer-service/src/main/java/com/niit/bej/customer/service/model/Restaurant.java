package com.niit.bej.customer.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.Objects;

public class Restaurant {
    @MongoId
    private long id;
    private String name;
    private String locationCity;
    private List<MenuItem> orders;

    public Restaurant() {
    }

    public Restaurant(long id, String name, String locationCity, List<MenuItem> orders) {
        this.id = id;
        this.name = name;
        this.locationCity = locationCity;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public List<MenuItem> getOrders() {
        return orders;
    }

    public void setOrders(List<MenuItem> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(locationCity, that.locationCity) && Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, locationCity, orders);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", locationCity='" + locationCity + '\'' +
                ", orders=" + orders +
                '}';
    }
}
