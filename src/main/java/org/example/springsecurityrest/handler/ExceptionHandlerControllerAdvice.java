package org.example.springsecurityrest.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import  org.example.springsecurityrest.exception.ServiceException;

import java.time.Instant;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
    @ExceptionHandler(ServiceException.class)
    public String handleServiceException(ServiceException e, HttpServletRequest request, Model model) {
        model.addAttribute("errorStatus", e.getErrorStatus());
        model.addAttribute("errorMessage", e.getErrorMessage());
        model.addAttribute("errorTimestamp", Instant.now().toString());
        model.addAttribute("errorUrl", request.getRequestURI().toString());
        return "error";
    }
}
