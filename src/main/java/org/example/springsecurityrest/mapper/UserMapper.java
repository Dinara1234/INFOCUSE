package org.example.springsecurityrest.mapper;

import org.example.springsecurityrest.dto.UserDto;
import org.example.springsecurityrest.entity.UserEntity;


public interface UserMapper {

    UserDto toDto(UserEntity user);
}
