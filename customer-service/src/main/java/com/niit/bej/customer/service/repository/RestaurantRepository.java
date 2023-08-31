package com.niit.bej.customer.service.repository;

import com.niit.bej.customer.service.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, Long> {
}
