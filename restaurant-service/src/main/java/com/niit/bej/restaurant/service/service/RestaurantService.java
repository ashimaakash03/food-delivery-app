package com.niit.bej.restaurant.service.service;

import com.niit.bej.restaurant.service.exception.RestaurantAlreadyExistException;
import com.niit.bej.restaurant.service.exception.RestaurantNotFoundException;
import com.niit.bej.restaurant.service.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant, byte[] bytes) throws RestaurantAlreadyExistException;

    Restaurant findByName(String restaurantName) throws RestaurantNotFoundException;

    List<Restaurant> getAllRestaurants();

    Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException;

    List<Restaurant> getRestaurant(int[] restaurantId) throws RestaurantNotFoundException;

    boolean deleteRestaurant(int restaurantId) throws RestaurantNotFoundException;

    List<Restaurant> getRestaurantByEmail(String email) throws RestaurantNotFoundException;
}
