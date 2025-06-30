package org.example.springsecurityrest.exception.user;

import org.example.springsecurityrest.exception.basic.NotFoundServiceException;

public class UserNotFoundException extends NotFoundServiceException {
    public UserNotFoundException(String userNme) {
        super("Пользователь "+userNme+" не найден");
    }
}
