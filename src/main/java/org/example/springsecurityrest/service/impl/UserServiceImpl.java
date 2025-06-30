package org.example.springsecurityrest.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.dto.PhotoSessionDto;
import org.example.springsecurityrest.dto.UserDto;
import org.example.springsecurityrest.entity.UserEntity;
import org.example.springsecurityrest.mapper.PhotoSessionMapper;
import org.example.springsecurityrest.mapper.UserMapper;
import org.example.springsecurityrest.repository.UserRepository;
import org.example.springsecurityrest.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PhotoSessionMapper photoSessionMapper;

    @Override
    public UserDto getUserFromAuthentication(Authentication authentication) {
        UserEntity user = userRepository.findByEmail(authentication.getName()).get();
        return userMapper.toDto(user);

    }

    @Override
    public Set<PhotoSessionDto> getAllUsersPhotosessions(Authentication authentication) {
        UserEntity user = userRepository.findByEmail(authentication.getName()).get();
        return user.getPhotoSessions().stream().map(photoSessionMapper::toDto).collect(Collectors.toSet());
    }
}
