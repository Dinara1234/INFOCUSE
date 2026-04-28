package org.example.springsecurityrest.mapper.impl;

import org.example.springsecurityrest.dto.PhotographerDetailsDto;
import org.example.springsecurityrest.dto.PhotographerDto;
import org.example.springsecurityrest.entity.PhotographerDetails;
import org.example.springsecurityrest.mapper.PhotographerMapper;
import org.springframework.stereotype.Component;

@Component
public class PhotographerMapperImpl implements PhotographerMapper {
    @Override
    public PhotographerDetailsDto toDto(PhotographerDetails details) {
        return PhotographerDetailsDto.builder()
                .title(details.getTitle())
                .photos(details.getPhotos()).build();
    }

    @Override
    public PhotographerDto toDtoForUsers(PhotographerDetails details) {
        return PhotographerDto.builder()
                .id(details.getId())
                .email(details.getUser().getEmail())
                .firstName(details.getUser().getFirstName())
                .lastName(details.getUser().getLastName())
                .title(details.getTitle())
                .photos(details.getPhotos())
                .build();
    }
}
