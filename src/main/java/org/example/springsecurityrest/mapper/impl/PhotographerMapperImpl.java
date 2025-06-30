package org.example.springsecurityrest.mapper.impl;

import org.example.springsecurityrest.dto.PhotographerDetailsDto;
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
}
