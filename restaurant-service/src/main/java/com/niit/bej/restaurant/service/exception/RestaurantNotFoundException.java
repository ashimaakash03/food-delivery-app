package com.niit.bej.restaurant.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Restaurant does not exist!")
public class RestaurantNotFoundException extends Exception {
    public RestaurantNotFoundException(String message){
        super(message);
    }
}
