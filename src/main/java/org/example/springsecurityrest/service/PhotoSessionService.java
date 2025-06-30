package org.example.springsecurityrest.service;

import org.example.springsecurityrest.dto.PhotoSessionDto;
import org.example.springsecurityrest.dto.request.CreatePhotoSessionRequest;
import org.example.springsecurityrest.entity.PhotographerDetails;
import org.springframework.security.core.Authentication;

import java.util.Set;

public interface PhotoSessionService {
    void createPhotoSession(CreatePhotoSessionRequest request, Authentication auth);
    Set<PhotoSessionDto> getActivePhotoSessions(Authentication auth);
    Set<PhotoSessionDto> getPhotoSessionsByPhotographer(Authentication auth);
    PhotoSessionDto getPhotoSessionById(Long id);

}
