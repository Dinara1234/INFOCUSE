package org.example.springsecurityrest.service;

import org.example.springsecurityrest.dto.PhotoStudioDto;
import org.example.springsecurityrest.dto.request.ChangePhotoStudioInfoRequest;
import org.example.springsecurityrest.dto.request.CreatePhotoStudioRequest;
import org.example.springsecurityrest.entity.Photo;
import org.example.springsecurityrest.entity.PhotoStudioEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface PhotoStudioService {

    List<PhotoStudioDto> getAllPhotoStudios();
    PhotoStudioDto getPhotoStudioById(Long id);
    void deletePhotoStudioById(Long id);
    void save(CreatePhotoStudioRequest request);
    void update(ChangePhotoStudioInfoRequest request);
    void setPhotoOfPhotoStudio(Long id, MultipartFile file);
    Set<Photo> getPhotosOfPhotoStudio(Long id);
}
