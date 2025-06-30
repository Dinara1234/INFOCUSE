package org.example.springsecurityrest.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.dto.PhotoSessionDto;
import org.example.springsecurityrest.dto.PhotographerDetailsDto;
import org.example.springsecurityrest.dto.request.UpdatePhotographerInfoRequest;
import org.example.springsecurityrest.entity.Photo;
import org.example.springsecurityrest.entity.PhotographerDetails;
import org.example.springsecurityrest.entity.UserEntity;
import org.example.springsecurityrest.exception.user.UserNotFoundException;
import org.example.springsecurityrest.mapper.PhotoSessionMapper;
import org.example.springsecurityrest.mapper.PhotographerMapper;
import org.example.springsecurityrest.repository.PhotoRepository;
import org.example.springsecurityrest.repository.PhotoSessionRepository;
import org.example.springsecurityrest.repository.PhotographerRepository;
import org.example.springsecurityrest.repository.UserRepository;
import org.example.springsecurityrest.service.ImageService;
import org.example.springsecurityrest.service.PhotographerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhotographerServiceImpl implements PhotographerService {
    private static final Logger log = LoggerFactory.getLogger(PhotographerServiceImpl.class);
    private final PhotographerRepository photographerRepository;
    private final PhotographerMapper photographerMapper;
    private final UserRepository userRepository;
    private final ImageService imageService;
    private final PhotoRepository photoRepository;
    private final PhotoSessionRepository photoSessionRepository;
    private final PhotoSessionMapper photoSessionMapper;

    @Override
    public PhotographerDetailsDto getPhotographerDetails(Authentication auth) {
        UserEntity user = userRepository.findByEmail(auth.getName()).orElseThrow(() -> new UserNotFoundException(auth.getName()));
        PhotographerDetails details = photographerRepository.findByUser(user);
        if (details == null) {
            return null;
        }
        return photographerMapper.toDto(details);

    }

    @Override
    public void setPhotoOfPhotographerByAuth(Authentication auth, MultipartFile file) {
        UserEntity user = userRepository.findByEmail(auth.getName()).get();
        String fileUrl = imageService.save(file);
        System.out.println(fileUrl);
        PhotographerDetails details = photographerRepository.findByUser(user);
        if (details == null) {
            details = PhotographerDetails.builder()
                    .user(user).build();

        }
        Photo photo = Photo.builder()
                .imageUrl(fileUrl)
                .photographer(details)
                .build();
        details.addPhoto(photo);
        user.setPhotographerDetails(details);
        userRepository.save(user);

    }

    @Override
    public Set<Photo> photosOfPhotographer(Authentication auth) {
        UserEntity user = userRepository.findByEmail(auth.getName()).get();
        PhotographerDetails details = photographerRepository.findByUser(user);
        return photoRepository.findByPhotographer(details);

    }

    @Override
    public void updateInformation(Authentication auth, UpdatePhotographerInfoRequest request) {
        UserEntity user = userRepository.findByEmail(auth.getName()).get();
        PhotographerDetails details = photographerRepository.findByUser(user);
        if(details == null) {
            details = new PhotographerDetails();
        }
        details.setTitle(request.getTitle());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhotographerDetails(details);
        details.setUser(user);
        userRepository.save(user);
    }

    @Override
    public Set<PhotoSessionDto> photoSessionsOfPhotographer(Authentication auth) {
        UserEntity user = userRepository.findByEmail(auth.getName()).get();
        PhotographerDetails details = photographerRepository.findByUser(user);

        return photoSessionRepository.findByPhotographerOrderByTimeStart(details).stream()
                .map(photoSessionMapper::toDto).collect(Collectors.toSet());

    }
}
