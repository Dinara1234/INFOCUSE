package org.example.springsecurityrest.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.dto.PhotoSessionDto;
import org.example.springsecurityrest.dto.request.CreatePhotoSessionRequest;
import org.example.springsecurityrest.entity.PhotoSessionEntity;
import org.example.springsecurityrest.entity.PhotographerDetails;
import org.example.springsecurityrest.entity.UserEntity;
import org.example.springsecurityrest.exception.user.PhotographerNotFound;
import org.example.springsecurityrest.exception.user.UserNotFoundException;
import org.example.springsecurityrest.mapper.PhotoSessionMapper;
import org.example.springsecurityrest.repository.PhotoSessionRepository;
import org.example.springsecurityrest.repository.PhotographerRepository;
import org.example.springsecurityrest.repository.UserRepository;
import org.example.springsecurityrest.service.PhotoSessionService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhotoSessionServiceImpl implements PhotoSessionService {
    private final PhotoSessionRepository photoSessionRepository;
    private final PhotoSessionMapper photoSessionMapper;
    private final UserRepository userRepository;
    private final PhotographerRepository photographerRepository;

    @Transactional
    @Override
    public void createPhotoSession(CreatePhotoSessionRequest request, Authentication auth) {
        UserEntity user = userRepository.findByEmail(auth.getName()).get();
        PhotographerDetails photographerDetails = photographerRepository.findById(request.getPhotographerId()).get();
        PhotoSessionEntity photoSessionEntity = photoSessionMapper.toEntity(request);
        photoSessionEntity.getUsers().add(user);
        user.getPhotoSessions().add(photoSessionEntity);
        photographerDetails.addPhotoSession(photoSessionEntity);
        photographerRepository.save(photographerDetails);
        photoSessionRepository.save(photoSessionEntity);

    }

    @Override
    public Set<PhotoSessionDto> getActivePhotoSessions(Authentication auth) {
        return photoSessionRepository.findFuturePhotosessionsWithAvailableSpots(LocalDateTime.now()).stream()
                .map(photoSessionMapper::toDto).collect(Collectors.toSet());
    }

    @Override
    public Set<PhotoSessionDto> getPhotoSessionsByPhotographer(Authentication auth) {
        UserEntity user = userRepository.findByEmail(auth.getName()).orElseThrow(() -> new UserNotFoundException(auth.getName()));
        PhotographerDetails photographerDetails =user.getPhotographerDetails();
        if(photographerDetails==null){
            throw new PhotographerNotFound(auth.getName());
        }
        return photoSessionRepository.findByPhotographerOrderByTimeStart(photographerDetails).stream()
                .map(photoSessionMapper::toDto).collect(Collectors.toSet());
    }

    @Override
    public PhotoSessionDto getPhotoSessionById(Long id) {
        return photoSessionRepository.findById(id).stream()
                .map(photoSessionMapper::toDto).findFirst().orElse(null);
    }


}
