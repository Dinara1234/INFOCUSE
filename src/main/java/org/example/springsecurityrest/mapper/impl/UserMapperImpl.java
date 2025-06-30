package org.example.springsecurityrest.mapper.impl;

import org.example.springsecurityrest.dto.UserDto;
import org.example.springsecurityrest.entity.UserEntity;
import org.example.springsecurityrest.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDto toDto(UserEntity user) {
        return UserDto.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
