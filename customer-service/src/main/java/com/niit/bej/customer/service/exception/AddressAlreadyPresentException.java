package com.niit.bej.customer.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Address already present", code = HttpStatus.CONFLICT)
public class AddressAlreadyPresentException extends Exception {
    public AddressAlreadyPresentException(String message) {
        super(message);
    }
}
