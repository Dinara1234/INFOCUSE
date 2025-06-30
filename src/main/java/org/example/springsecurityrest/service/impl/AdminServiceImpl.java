package org.example.springsecurityrest.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.entity.UserEntity;
import org.example.springsecurityrest.repository.UserRepository;
import org.example.springsecurityrest.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }
}
