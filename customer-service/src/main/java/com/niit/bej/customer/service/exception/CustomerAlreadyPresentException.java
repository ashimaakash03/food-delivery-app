package com.niit.bej.customer.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Customer is already present", code = HttpStatus.CONFLICT)
public class CustomerAlreadyPresentException extends Exception {
    public CustomerAlreadyPresentException(String message) {
        super(message);
    }
}
