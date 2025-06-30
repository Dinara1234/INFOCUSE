package org.example.springsecurityrest.mapper;

import org.example.springsecurityrest.dto.PhotoStudioDto;
import org.example.springsecurityrest.dto.request.ChangePhotoStudioInfoRequest;
import org.example.springsecurityrest.dto.request.CreatePhotoStudioRequest;
import org.example.springsecurityrest.entity.PhotoStudioEntity;

public interface PhotoStudioMapper {

    PhotoStudioDto toDto(PhotoStudioEntity photoStudioEntity);

    PhotoStudioEntity toEntity(CreatePhotoStudioRequest request);

    void update(ChangePhotoStudioInfoRequest request, PhotoStudioEntity photoStudio);
}
