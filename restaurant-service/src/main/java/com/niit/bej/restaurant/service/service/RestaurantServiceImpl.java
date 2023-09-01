package com.niit.bej.restaurant.service.service;

import com.niit.bej.restaurant.service.model.Menu;
import com.niit.bej.restaurant.service.model.Restaurant;
import com.niit.bej.restaurant.service.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return null;
    }

    @Override
    public List<Restaurant> findAllRestaurantsByName(String restaurantName) {
        return null;
    }

    @Override
    public List<Restaurant> findAllRestaurants() {
        return null;
    }

    @Override
    public List<Restaurant> findAllRestaurantsByCity(String city) {
        return null;
    }

    @Override
    public Restaurant updateRestaurantById(Restaurant restaurant, int restaurantId) {
        return null;
    }

    @Override
    public boolean deleteRestaurantById(int restaurantId) {
        return false;
    }

    @Override
    public Menu addMenuItem(Menu menu) {
        return null;
    }

    @Override
    public List<Menu> findAllItemsUnderCategory(String category) {
        return null;
    }

    @Override
    public Menu findItemByName(String itemName) {
        return null;
    }

    @Override
    public List<Menu> findAllMenuItems() {
        return null;
    }

    @Override
    public Menu updateMenuItemDetails(Menu menu) {
        return null;
    }

    @Override
    public boolean deleteMenuItemById(long id) {
        return false;
    }

    @Override
    public boolean deleteMenuItemByName(String itemName) {
        return false;
    }
}
