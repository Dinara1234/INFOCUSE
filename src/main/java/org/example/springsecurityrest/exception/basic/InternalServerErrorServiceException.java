package org.example.springsecurityrest.exception.basic;

import lombok.Getter;
import org.example.springsecurityrest.exception.ServiceException;

@Getter
public class InternalServerErrorServiceException extends ServiceException {
    public InternalServerErrorServiceException(String errorMessage) {
        super(500, errorMessage);
    }
}
