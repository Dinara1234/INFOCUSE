package org.example.springsecurityrest.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
public class ServiceException extends RuntimeException {

    /**
     * HTTP-код статуса ошибки
     */
    private final int errorStatus;

    /**
     * User-friendly сообщение об ошибке
     */
    private final String errorMessage;

    /**
     * Причина возникновения исключения
     */
    @Setter
    private Exception cause;

    public ServiceException(int errorStatus, String errorMessage) {
        super(errorMessage);
        this.errorStatus = errorStatus;
        this.errorMessage = errorMessage;
    }
}