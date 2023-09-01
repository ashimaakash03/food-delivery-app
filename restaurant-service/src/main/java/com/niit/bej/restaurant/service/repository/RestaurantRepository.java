package com.niit.bej.restaurant.service.repository;

import com.niit.bej.restaurant.service.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, Integer> {
    List<Restaurant> findByRestaurantNameContaining(String restaurantName);

    Restaurant findByRestaurantId(int restaurantId);

    Restaurant findByRestaurantName(String restaurantName);

    Restaurant findByEmail(String email);

    Restaurant findByCity(String city);

    List<Restaurant> findByEmailContaining(String email);
}
