package org.example.springsecurityrest.exception.image;

import org.example.springsecurityrest.exception.basic.BadRequestServiceException;

public class IncorrectMediaTypeServiceException extends BadRequestServiceException {
    public IncorrectMediaTypeServiceException() {
        super("Incorrect media type");
    }
}
