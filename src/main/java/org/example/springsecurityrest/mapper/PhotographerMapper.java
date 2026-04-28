package org.example.springsecurityrest.mapper;

import org.example.springsecurityrest.dto.PhotographerDetailsDto;
import org.example.springsecurityrest.dto.PhotographerDto;
import org.example.springsecurityrest.entity.PhotographerDetails;


public interface PhotographerMapper {

    PhotographerDetailsDto toDto(PhotographerDetails details);

    PhotographerDto toDtoForUsers(PhotographerDetails details);
}
