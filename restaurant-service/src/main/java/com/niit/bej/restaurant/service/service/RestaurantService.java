package com.niit.bej.restaurant.service.service;

import com.niit.bej.restaurant.service.exception.*;
import com.niit.bej.restaurant.service.model.Menu;
import com.niit.bej.restaurant.service.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistException;

    List<Restaurant> findAllRestaurantsByName(String restaurantName) throws EmptyDatabaseException;

    List<Restaurant> findAllRestaurants() throws EmptyDatabaseException;

    List<Restaurant> findAllRestaurantsByCity(String city) throws EmptyDatabaseException;

    Restaurant updateRestaurantById(Restaurant restaurant) throws RestaurantNotFoundException;

    boolean deleteRestaurantById(int restaurantId) throws RestaurantNotFoundException;

    Menu addMenuItem(int restaurantId, Menu menu) throws ItemAlreadyPresentException, RestaurantNotFoundException;

    List<Menu> findAllItemsUnderCategory(int restaurantId, String category) throws RestaurantNotFoundException, EmptyDatabaseException;

    Menu findItemByName(int restaurantId, String itemName) throws EmptyDatabaseException, ItemNotFoundException, RestaurantNotFoundException;

    List<Menu> findAllMenuItems(int restaurantId) throws EmptyDatabaseException, RestaurantNotFoundException;

    Menu updateMenuItemDetails(int restaurantId, Menu menu) throws EmptyDatabaseException, RestaurantNotFoundException;

    boolean deleteMenuItemById(int restaurantId, long id) throws ItemNotFoundException, RestaurantNotFoundException;

    boolean deleteMenuItemByName(int restaurantId, String itemName) throws RestaurantNotFoundException, ItemNotFoundException;
}
