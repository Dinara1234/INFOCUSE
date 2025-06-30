package org.example.springsecurityrest.service;

import org.example.springsecurityrest.dto.request.SignUpRequest;

public interface SignUpService {

    boolean signUp(SignUpRequest signUpRequest);
}
