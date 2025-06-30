package org.example.springsecurityrest.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(public * org.example.springsecurityrest.controller.*.*(..))")
    public void callPublicServiceMethod() {
    }

    @Before("callPublicServiceMethod()")
    public void logMethodCall(JoinPoint joinPoint) {
        String args = Arrays.stream(joinPoint.getArgs())
                .map(arg -> arg != null ? arg.toString() : "null") // Обработка null
                .collect(Collectors.joining(", "));
        log.info("Вызов метода {} с аргументами {}", joinPoint.getSignature(),  args);
    }

}

