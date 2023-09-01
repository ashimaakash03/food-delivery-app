package com.niit.bej.restaurant.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "No restaurants exist in the database!")
public class RestaurantsNotFoundException extends Exception {
    public RestaurantsNotFoundException(String message){
        super(message);
    }
}
