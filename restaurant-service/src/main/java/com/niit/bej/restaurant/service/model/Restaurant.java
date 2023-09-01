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

}
