package org.example.springsecurityrest.repository;

import org.example.springsecurityrest.entity.PhotographerDetails;
import org.example.springsecurityrest.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;


public interface PhotographerRepository extends JpaRepository<PhotographerDetails, Long> {

    @Query("SELECT d FROM PhotographerDetails d WHERE d.user = :user")
    PhotographerDetails findByUser(@Param("user") UserEntity user);

    @Query("SELECT p FROM PhotographerDetails p WHERE NOT EXISTS (" +
            "    SELECT ps FROM p.photoSessions ps " +
            "    WHERE (ps.timeStart < :endTime AND ps.timeEnd > :startTime)" +
            ")")
    List<PhotographerDetails> findFreePhotographers(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

}
