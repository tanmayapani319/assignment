package com.avaloq.diceassignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoDataFoundExcetion extends ResponseStatusException {

    public NoDataFoundExcetion(final String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
    
}
