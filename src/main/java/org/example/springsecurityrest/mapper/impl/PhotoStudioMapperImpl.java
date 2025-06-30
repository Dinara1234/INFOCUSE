package org.example.springsecurityrest.mapper.impl;

import org.example.springsecurityrest.dto.PhotoStudioDto;
import org.example.springsecurityrest.dto.request.ChangePhotoStudioInfoRequest;
import org.example.springsecurityrest.dto.request.CreatePhotoStudioRequest;
import org.example.springsecurityrest.entity.PhotoStudioEntity;
import org.example.springsecurityrest.mapper.PhotoStudioMapper;
import org.springframework.stereotype.Component;

@Component
public class PhotoStudioMapperImpl implements PhotoStudioMapper {
    @Override
    public PhotoStudioDto toDto(PhotoStudioEntity photoStudioEntity) {
        return PhotoStudioDto.builder()
                .id(photoStudioEntity.getId())
                .title(photoStudioEntity.getTitle())
                .address(photoStudioEntity.getAddress())
                .photos(photoStudioEntity.getPhotos())
                .build();
    }

    @Override
    public PhotoStudioEntity toEntity(CreatePhotoStudioRequest request) {
        return PhotoStudioEntity.builder()
                .title(request.getTitle())
                .address(request.getAddress())
                .build();
    }

    @Override
    public void update(ChangePhotoStudioInfoRequest request, PhotoStudioEntity photoStudio) {
        photoStudio.setTitle(request.getTitle());
        photoStudio.setAddress(request.getAddress());

    }
}
