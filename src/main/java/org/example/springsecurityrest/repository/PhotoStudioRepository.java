package org.example.springsecurityrest.repository;

import org.example.springsecurityrest.entity.PhotoStudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PhotoStudioRepository extends JpaRepository<PhotoStudioEntity, Long> {
    Optional<PhotoStudioEntity> findById(Long id);
    List<PhotoStudioEntity> findAll();
    int deleteById(long id);
    Optional<PhotoStudioEntity> findByAddress(String address);
}
