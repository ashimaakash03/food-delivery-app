package com.niit.bej.restaurant.service.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.Objects;

@Document(collection = "restaurant")
public class Restaurant {
    @MongoId
    private int restaurantId;
    private String restaurantName;
    private String city;
    private List<Menu> menuList;

    public Restaurant() {
    }

    public Restaurant(int restaurantId, String restaurantName, String city, List<Menu> menuList) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.city = city;
        this.menuList = menuList;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return restaurantId == that.restaurantId && Objects.equals(restaurantName, that.restaurantName) && Objects.equals(city, that.city) && Objects.equals(menuList, that.menuList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantId, restaurantName, city, menuList);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", city='" + city + '\'' +
                ", menuList=" + menuList +
                '}';
    }
}
