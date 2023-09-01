package com.niit.bej.restaurant.service.model;

import java.util.List;

public class Restaurant {
    private int restaurantId;
    private String email;
    private String restaurantName;
    private String city;
    private byte[] url;
    private List<Menu> menuList;

    public Restaurant() {
    }

    public Restaurant(int restaurantId, String email, String restaurantName, String city, byte[] url, List<Menu> menuList) {
        this.restaurantId = restaurantId;
        this.email = email;
        this.restaurantName = restaurantName;
        this.city = city;
        this.url = url;
        this.menuList = menuList;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public byte[] getUrl() {
        return url;
    }

    public void setUrl(byte[] url) {
        this.url = url;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

}
