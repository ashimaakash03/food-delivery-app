package com.niit.bej.customer.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Nothing Found in Database", code = HttpStatus.NO_CONTENT)
public class EmptyDatabaseException extends Exception {
    public EmptyDatabaseException(String message) {
        super(message);
    }
}
