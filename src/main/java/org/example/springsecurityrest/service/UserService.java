package org.example.springsecurityrest.service;

import org.example.springsecurityrest.dto.PhotoSessionDto;
import org.example.springsecurityrest.dto.UserDto;
import org.example.springsecurityrest.entity.UserEntity;
import org.springframework.security.core.Authentication;

import java.util.Set;

public interface UserService {
    UserDto getUserFromAuthentication(Authentication authentication);
    Set<PhotoSessionDto> getAllUsersPhotosessions(Authentication authentication);


}
