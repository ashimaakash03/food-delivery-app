package com.niit.bej.restaurant.service.service;

import com.niit.bej.restaurant.service.model.Menu;
import com.niit.bej.restaurant.service.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);

    List<Restaurant> findAllRestaurantsByName(String restaurantName);

    List<Restaurant> findAllRestaurants();

    List<Restaurant> findAllRestaurantsByCity(String city);

    Restaurant updateRestaurantById(Restaurant restaurant, int restaurantId);

    boolean deleteRestaurantById(int restaurantId);

    Menu addMenuItem(Menu menu);

    List<Menu> findAllItemsUnderCategory(String category);

    Menu findItemByName(String itemName);

    List<Menu> findAllMenuItems();

    Menu updateMenuItemDetails(Menu menu);

    boolean deleteMenuItemById(long id);

    boolean deleteMenuItemByName(String itemName);
}
