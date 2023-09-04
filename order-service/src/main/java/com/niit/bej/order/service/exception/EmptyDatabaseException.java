package com.niit.bej.order.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Nothing present in the database", code = HttpStatus.NO_CONTENT)
public class EmptyDatabaseException extends Exception {
    public EmptyDatabaseException(String message) {
        super(message);
    }
}
