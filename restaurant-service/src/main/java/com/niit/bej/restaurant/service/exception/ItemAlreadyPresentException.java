package com.niit.bej.restaurant.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Item already present in the menu", code = HttpStatus.CONFLICT)
public class ItemAlreadyPresentException extends Exception {
    public ItemAlreadyPresentException(String message) {
        super(message);
    }
}
