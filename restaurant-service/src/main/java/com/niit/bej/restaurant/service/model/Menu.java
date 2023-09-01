package com.niit.bej.restaurant.service.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

public class Menu {
    @MongoId
    private long id;
    private String itemName;
    private String category;
    private double price;

    public Menu() {
    }

    public Menu(long id, String itemName, String category, double price) {
        this.id = id;
        this.itemName = itemName;
        this.category = category;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id && Double.compare(price, menu.price) == 0 && Objects.equals(itemName, menu.itemName) && Objects.equals(category, menu.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName, category, price);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
