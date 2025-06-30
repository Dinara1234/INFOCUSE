package org.example.springsecurityrest.service;

import org.example.springsecurityrest.entity.UserEntity;

import java.util.List;

public interface AdminService {
    List<UserEntity> findAllUsers();
}
