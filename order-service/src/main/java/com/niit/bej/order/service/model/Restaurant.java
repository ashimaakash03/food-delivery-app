package com.niit.bej.order.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.Objects;

public class Restaurant {
    @MongoId
    private long id;
    private String name;
    private String city;
    private List<Item> order;

    public Restaurant() {
    }

    public Restaurant(long id, String name, String city, List<Item> order) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.order = order;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Item> getOrder() {
        return order;
    }

    public void setOrder(List<Item> order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(city, that.city) && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, order);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", order=" + order +
                '}';
    }
}
