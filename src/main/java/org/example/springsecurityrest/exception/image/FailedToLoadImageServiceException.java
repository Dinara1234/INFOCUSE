package org.example.springsecurityrest.exception.image;

import org.example.springsecurityrest.exception.basic.BadRequestServiceException;

public class FailedToLoadImageServiceException extends BadRequestServiceException {
    public FailedToLoadImageServiceException(String message) {
        super("Failed to load image: " + message);
    }
}
