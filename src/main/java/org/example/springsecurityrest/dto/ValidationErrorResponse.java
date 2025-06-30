package org.example.springsecurityrest.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {
    private List<ValidationError> errors = new ArrayList<>();

    public void addError(String field, String message) {
        this.errors.add(new ValidationError(field, message));
    }

    // Геттеры
    public List<ValidationError> getErrors() {
        return errors;
    }

    public static class ValidationError {
        private final String field;
        private final String message;

        public ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        // Геттеры
        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }
    }
}