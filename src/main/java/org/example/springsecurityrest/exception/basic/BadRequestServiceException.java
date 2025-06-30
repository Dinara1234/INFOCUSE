package org.example.springsecurityrest.exception.basic;

import lombok.Getter;
import org.example.springsecurityrest.exception.ServiceException;

@Getter
public class BadRequestServiceException extends ServiceException {
    public BadRequestServiceException(String errorMessage) {
        super(400, errorMessage);
    }
}
