package org.example.springsecurityrest.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.dto.PhotoStudioDto;
import org.example.springsecurityrest.dto.request.ChangePhotoStudioInfoRequest;
import org.example.springsecurityrest.dto.request.CreatePhotoStudioRequest;
import org.example.springsecurityrest.entity.Photo;
import org.example.springsecurityrest.entity.PhotoStudioEntity;
import org.example.springsecurityrest.mapper.PhotoStudioMapper;
import org.example.springsecurityrest.repository.PhotoRepository;
import org.example.springsecurityrest.repository.PhotoStudioRepository;
import org.example.springsecurityrest.service.ImageService;
import org.example.springsecurityrest.service.PhotoStudioService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhotoStudioServiceImpl implements PhotoStudioService {
    private final PhotoStudioRepository photoStudioRepository;
    private final PhotoStudioMapper photoStudioMapper;
    private final ImageService imageService;
    private final PhotoRepository photoRepository;

    @Override
    public List<PhotoStudioDto> getAllPhotoStudios() {
        return photoStudioRepository.findAll().stream().map(photoStudioMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PhotoStudioDto getPhotoStudioById(Long id) {
        return photoStudioRepository.findById(id).map(photoStudioMapper::toDto).orElse(null);
    }

    @Transactional
    @Override
    public void deletePhotoStudioById(Long id) {
         photoStudioRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void save(CreatePhotoStudioRequest request) {
        PhotoStudioEntity photoStudioEntity = photoStudioMapper.toEntity(request);
        photoStudioRepository.save(photoStudioEntity);
    }

    @Transactional
    @Override
    public void update(ChangePhotoStudioInfoRequest request) {
        PhotoStudioEntity photoStudio = photoStudioRepository.findById(request.getId()).orElse(null);
        photoStudioMapper.update(request, photoStudio);
        photoStudioRepository.save(photoStudio);
    }

    @Override
    public void setPhotoOfPhotoStudio(Long id, MultipartFile file) {
        PhotoStudioEntity photoStudio = photoStudioRepository.findById(id).get();
        String fileUrl = imageService.save(file);
        System.out.println(fileUrl);
        Photo photo = Photo.builder()
                .imageUrl(fileUrl)
                .photoStudio(photoStudio)
                .build();
        photoStudio.addPhoto(photo);
        photoStudioRepository.save(photoStudio);
    }

    @Override
    public Set<Photo> getPhotosOfPhotoStudio(Long id) {
        PhotoStudioEntity photoStudio = photoStudioRepository.findById(id).get();
        Set<Photo> photos = photoRepository.findByPhotoStudio(photoStudio);
        return photos;
    }


}
