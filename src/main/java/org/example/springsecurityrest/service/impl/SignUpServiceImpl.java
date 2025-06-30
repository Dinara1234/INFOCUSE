package org.example.springsecurityrest.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.dto.request.SignUpRequest;
import org.example.springsecurityrest.entity.UserEntity;
import org.example.springsecurityrest.exception.image.FailedToLoadImageServiceException;
import org.example.springsecurityrest.repository.UserRepository;
import org.example.springsecurityrest.service.SignUpService;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean signUp(SignUpRequest signUpRequest) {
        try{
            if(signUpRequest.getRole().equals("user")){
                userRepository.save(UserEntity.builder()
                                .firstName(signUpRequest.getFirstName())
                                .lastName(signUpRequest.getLastName())
                                .email(signUpRequest.getEmail())
                                .hashPassword(passwordEncoder.encode(signUpRequest.getPassword()))
                                .role(UserEntity.Role.USER)
                                .state(UserEntity.State.OK)
                                .build());
            }

            if(signUpRequest.getRole().equals("photographer")){
                userRepository.save(UserEntity.builder()
                                .firstName(signUpRequest.getFirstName())
                                .lastName(signUpRequest.getLastName())
                                .email(signUpRequest.getEmail())
                                .hashPassword(passwordEncoder.encode(signUpRequest.getPassword()))
                                .role(UserEntity.Role.PHOTOGRAPHER)
                                .state(UserEntity.State.OK)
                                .build());

            }
            return true;

        }catch(DataAccessException e){
            return false;
        }

    }
}
