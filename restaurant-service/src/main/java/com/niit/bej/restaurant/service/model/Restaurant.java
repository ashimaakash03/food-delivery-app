package com.niit.bej.restaurant.service.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        if (restaurantId != that.restaurantId) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(restaurantName, that.restaurantName)) return false;
        if (!Objects.equals(city, that.city)) return false;
        if (!Arrays.equals(url, that.url)) return false;
        return Objects.equals(menuList, that.menuList);
    }

    @Override
    public int hashCode() {
        int result = restaurantId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (restaurantName != null ? restaurantName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(url);
        result = 31 * result + (menuList != null ? menuList.hashCode() : 0);
        return result;
    }

}
