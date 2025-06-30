package org.example.springsecurityrest.exception.user;

import org.example.springsecurityrest.exception.basic.NotFoundServiceException;

public class PhotographerNotFound extends NotFoundServiceException {
    public PhotographerNotFound(String errorMessage) {
        super("Не найден фотограф "+errorMessage);
    }
}
