package org.example.springsecurityrest.service;

import org.example.springsecurityrest.dto.*;
import org.example.springsecurityrest.dto.request.UpdatePhotographerInfoRequest;
import org.example.springsecurityrest.entity.Photo;
import org.example.springsecurityrest.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface PhotographerService {
    PhotographerDto getPhotographerById(Long id);

    PhotographerDetailsDto getPhotographerDetails(Authentication auth);
    void setPhotoOfPhotographerByAuth(Authentication auth, MultipartFile  file);
    Set<Photo> photosOfPhotographer(Authentication auth);
    void updateInformation(Authentication auth, UpdatePhotographerInfoRequest request);
    Set<PhotoSessionDto> photoSessionsOfPhotographer(Authentication auth);
    List<PhotographerDto> getAllPhotographers();
}
