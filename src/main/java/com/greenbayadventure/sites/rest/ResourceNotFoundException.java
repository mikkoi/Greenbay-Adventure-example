package com.greenbayadventure.sites.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * HTTP Status Code 404.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    /**
     * Constructor.
     * @param message - Exception message
     * */
    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
