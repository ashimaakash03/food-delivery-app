package com.niit.bej.restaurant.service.service;

import com.niit.bej.restaurant.service.exception.RestaurantAlreadyExistException;
import com.niit.bej.restaurant.service.exception.RestaurantNotFoundException;
import com.niit.bej.restaurant.service.model.Restaurant;
import com.niit.bej.restaurant.service.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant, byte[] bytes) throws RestaurantAlreadyExistException {
        return null;
    }

    @Override
    public Restaurant findByName(String restaurantName) throws RestaurantNotFoundException {
        return null;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return null;
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
        return null;
    }

    @Override
    public List<Restaurant> getRestaurant(int[] restaurantId) throws RestaurantNotFoundException {
        return null;
    }

    @Override
    public boolean deleteRestaurant(int restaurantId) throws RestaurantNotFoundException {
        return false;
    }

    @Override
    public List<Restaurant> getRestaurantByEmail(String email) throws RestaurantNotFoundException {
        return null;
    }
}
