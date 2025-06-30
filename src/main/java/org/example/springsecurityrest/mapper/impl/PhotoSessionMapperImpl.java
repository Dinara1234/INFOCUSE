package org.example.springsecurityrest.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.dto.PhotoSessionDto;
import org.example.springsecurityrest.dto.request.CreatePhotoSessionRequest;
import org.example.springsecurityrest.entity.PhotoSessionEntity;
import org.example.springsecurityrest.mapper.PhotoSessionMapper;
import org.example.springsecurityrest.repository.PhotoStudioRepository;
import org.example.springsecurityrest.repository.PhotographerRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PhotoSessionMapperImpl implements PhotoSessionMapper {
    private final PhotoStudioRepository photoStudioRepository;
    private final PhotographerRepository photographerRepository;
    @Override
    public PhotoSessionEntity toEntity(CreatePhotoSessionRequest request) {
        return PhotoSessionEntity.builder()
                .photoStudio(photoStudioRepository.findById(request.getPhotoStudioId()).get())
                .photographer(photographerRepository.findById(request.getPhotographerId()).get())
                .title(request.getTitle())
                .timeStart(request.getTimeStart())
                .timeEnd(request.getTimeEnd())
                .quantityOfModels(request.getQuantityOfModels())
                .build();
    }

    @Override
    public PhotoSessionDto toDto(PhotoSessionEntity entity) {
        return PhotoSessionDto.builder()
                .address(entity.getPhotoStudio().getAddress())
                .photographerFirstName(entity.getPhotographer().getUser().getFirstName())
                .photographerEmail(entity.getPhotographer().getUser().getEmail())
                .photographerLastName(entity.getPhotographer().getUser().getLastName())
                .timeStart(entity.getTimeStart())
                .timeEnd(entity.getTimeEnd())
                .title(entity.getTitle()).build();
    }
}
