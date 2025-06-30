package org.example.springsecurityrest.exception.basic;

import lombok.Getter;
import org.example.springsecurityrest.exception.ServiceException;

@Getter
public class NotFoundServiceException extends ServiceException {
    public NotFoundServiceException(String errorMessage) {
        super(404, errorMessage);
    }
}
