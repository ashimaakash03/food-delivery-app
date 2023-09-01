package com.niit.bej.restaurant.service.repository;

import com.niit.bej.restaurant.service.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, Integer> {
    List<Restaurant> findByRestaurantName(String restaurantName);

    List<Restaurant> findByCity(String city);
}
