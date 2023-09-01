package com.niit.bej.restaurant.service.repository;

import com.niit.bej.restaurant.service.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<Restaurant, Integer> {

}
