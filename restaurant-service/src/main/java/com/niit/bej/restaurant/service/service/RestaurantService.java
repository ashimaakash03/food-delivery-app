package com.niit.bej.restaurant.service.service;

import com.niit.bej.restaurant.service.exception.RestaurantAlreadyExistException;
import com.niit.bej.restaurant.service.exception.RestaurantNotFoundException;
import com.niit.bej.restaurant.service.model.Restaurant;

public interface RestaurantService {
    public Restaurant addRestaurant(Restaurant restaurant, byte[] bytes) throws RestaurantAlreadyExistException;
    public Restaurant findByName(String restaurantName) throws RestaurantNotFoundException;

}
