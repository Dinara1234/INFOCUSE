package org.example.springsecurityrest.exception.basic;

import lombok.Getter;
import org.example.springsecurityrest.exception.ServiceException;

@Getter
public class AccessDeniedServiceException extends ServiceException {
    public AccessDeniedServiceException(String errorMessage) {
        super(403, errorMessage);
    }
}
