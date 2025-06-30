package org.example.springsecurityrest.mapper;

import org.example.springsecurityrest.dto.PhotographerDetailsDto;
import org.example.springsecurityrest.entity.PhotographerDetails;


public interface PhotographerMapper {

    PhotographerDetailsDto toDto(PhotographerDetails details);
}
