package org.example.springsecurityrest.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.entity.PhotographerDetails;
import org.example.springsecurityrest.mapper.PhotographerMapper;
import org.example.springsecurityrest.repository.PhotographerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotographerAvailabilityService {

    private final PhotographerRepository photographerDetailsRepository;

    @Transactional(readOnly = true)
    public List<PhotographerDetails> findAvailablePhotographers(LocalDateTime startTime, LocalDateTime endTime) {
        List<PhotographerDetails> freePhotographers = photographerDetailsRepository.findFreePhotographers(startTime, endTime);

        return freePhotographers;
    }
}