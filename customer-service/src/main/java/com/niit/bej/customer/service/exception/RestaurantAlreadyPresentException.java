package com.niit.bej.customer.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Restaurant Already Present", code = HttpStatus.CONFLICT)
public class RestaurantAlreadyPresentException extends Exception {
    public RestaurantAlreadyPresentException(String message) {
        super(message);
    }
}
