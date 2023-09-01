package com.niit.bej.restaurant.service.service;

import com.niit.bej.restaurant.service.exception.RestaurantAlreadyExistException;
import com.niit.bej.restaurant.service.exception.RestaurantNotFoundException;
import com.niit.bej.restaurant.service.exception.RestaurantsNotFoundException;
import com.niit.bej.restaurant.service.model.Restaurant;
import com.niit.bej.restaurant.service.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant, byte[] bytes) throws RestaurantAlreadyExistException {
        if (restaurantRepository.findById(restaurant.getRestaurantId()).isPresent()) {
            throw new RestaurantAlreadyExistException("Restaurant already exists!!!");
        } else {
            restaurant.setUrl(bytes);
            restaurantRepository.save(restaurant);
            System.out.println("Restaurant saved successfully!!");
        }
        return restaurant;
    }

    @Override
    public Restaurant findByName(String restaurantName) throws RestaurantNotFoundException {
        Restaurant restaurant = restaurantRepository.findByRestaurantName(restaurantName);
        if (restaurant.getRestaurantName().equals(restaurantName)) {
            return restaurant;
        } else {
            throw new RestaurantNotFoundException("Restaurant does not exist in the database!!");
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
        if (restaurantRepository.findById(restaurant.getRestaurantId()).isEmpty()) {
            throw new RestaurantNotFoundException("Restaurant not found in the database :(");
        } else {
            Restaurant restaurantToBeUpdated = restaurantRepository.findById(restaurant.getRestaurantId()).get();
            if (restaurant.getUrl() == null) {
                restaurant.setUrl(restaurantToBeUpdated.getUrl());
            }
            return restaurantRepository.save(restaurant);
        }
    }

    @Override
    public List<Restaurant> getRestaurants(int[] restaurantIds) throws RestaurantsNotFoundException {
        List<Restaurant> restaurantList = new ArrayList<>();

        for (int id : restaurantIds) {
            Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
            if (optionalRestaurant.isPresent()) {
                Restaurant restaurant = optionalRestaurant.get();
                restaurantList.add(restaurant);
            } else {
                throw new RestaurantsNotFoundException("Restaurant id " + id + " not found");
            }
        }
        return restaurantList;
    }

    @Override
    public boolean deleteRestaurant(int restaurantId) throws RestaurantNotFoundException {
        Restaurant restaurant = new Restaurant();
        if (restaurantRepository.findById(restaurantId).isEmpty()) {
            throw new RestaurantNotFoundException(" Restaurant not found in the database!");
        } else {
            restaurant = restaurantRepository.findById(restaurantId).get();
            restaurantRepository.delete(restaurant);
        }
        return true;
    }

    @Override
    public List<Restaurant> getRestaurantsByEmail(String email) throws RestaurantsNotFoundException {
        List<Restaurant> restaurantList = new ArrayList<>();
        restaurantList = restaurantRepository.findByEmailContaining(email);
        return restaurantList;
    }
}
