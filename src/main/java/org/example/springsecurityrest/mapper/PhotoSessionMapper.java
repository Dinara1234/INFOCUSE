package org.example.springsecurityrest.mapper;

import org.example.springsecurityrest.dto.PhotoSessionDto;
import org.example.springsecurityrest.dto.request.CreatePhotoSessionRequest;
import org.example.springsecurityrest.entity.PhotoSessionEntity;

public interface PhotoSessionMapper {
    PhotoSessionEntity toEntity(CreatePhotoSessionRequest request);

    PhotoSessionDto toDto(PhotoSessionEntity entity);
}
