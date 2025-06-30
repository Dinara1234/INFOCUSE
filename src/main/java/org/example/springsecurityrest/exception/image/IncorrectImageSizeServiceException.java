package org.example.springsecurityrest.exception.image;

import org.example.springsecurityrest.exception.basic.BadRequestServiceException;

public class IncorrectImageSizeServiceException extends BadRequestServiceException {
    public IncorrectImageSizeServiceException() {
        super("Incorrect image size");
    }
}
