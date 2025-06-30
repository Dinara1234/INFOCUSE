package org.example.springsecurityrest.repository;

import org.example.springsecurityrest.entity.PhotoSessionEntity;
import org.example.springsecurityrest.entity.PhotoStudioEntity;
import org.example.springsecurityrest.entity.PhotographerDetails;
import org.example.springsecurityrest.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PhotoSessionRepository extends JpaRepository<PhotoSessionEntity, Long> {


    Optional<PhotoSessionEntity> findById(Long id);
    Set<PhotoSessionEntity> findByPhotographerOrderByTimeStart(PhotographerDetails photographer);


    @Query("SELECT ps FROM PhotoSessionEntity ps " +
            "WHERE ps.photoStudio = :photoStudio " +
            "AND (" +
            "    (ps.timeStart < :searchEnd AND ps.timeEnd > :searchStart)" +
            ") ORDER BY ps.timeStart ASC")
    List<PhotoSessionEntity> findOverlappingSessionsForStudio(
            @Param("photoStudio") PhotoStudioEntity photoStudio,
            @Param("searchStart") LocalDateTime searchStart,
            @Param("searchEnd") LocalDateTime searchEnd);

    @Query("SELECT p FROM PhotoSessionEntity p " +
            "WHERE p.timeStart > :currentTime " +
            "AND size(p.users) < p.quantityOfModels")
    List<PhotoSessionEntity> findFuturePhotosessionsWithAvailableSpots(LocalDateTime currentTime);








}
