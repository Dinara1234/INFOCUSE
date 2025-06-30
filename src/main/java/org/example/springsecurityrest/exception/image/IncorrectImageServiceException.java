package org.example.springsecurityrest.exception.image;

import org.example.springsecurityrest.exception.basic.BadRequestServiceException;

public class IncorrectImageServiceException extends BadRequestServiceException {
    public IncorrectImageServiceException() {
        super("An error occurred when uploading an image");
    }
}
