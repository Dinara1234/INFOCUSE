package org.example.springsecurityrest.service.impl;

import org.example.springsecurityrest.entity.PhotoSessionEntity;
import org.example.springsecurityrest.entity.PhotoStudioEntity;
import org.example.springsecurityrest.entity.TimePeriod;
import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.repository.PhotoSessionRepository;
import org.example.springsecurityrest.repository.PhotoStudioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhotoStudioAvailabilityService {
    private final PhotoSessionRepository photoSessionRepository;
    private final PhotoStudioRepository photoStudioRepository; // Для получения PhotoStudioEntity


    @Transactional(readOnly = true)
    public List<TimePeriod> findFreeTimeSlots(
            Long studioId,
            LocalDateTime searchStart,
            LocalDateTime searchEnd,
            Duration desiredSlotDuration,
            Duration checkGranularity
    ) {
        Optional<PhotoStudioEntity> studioOptional = photoStudioRepository.findById(studioId);
        if (studioOptional.isEmpty()) {
            return new ArrayList<>();
        }
        PhotoStudioEntity photoStudio = studioOptional.get();

        List<PhotoSessionEntity> occupiedSessions = photoSessionRepository.findOverlappingSessionsForStudio(
                photoStudio, searchStart, searchEnd
        );

        List<TimePeriod> mergedOccupiedPeriods = mergeOverlappingPeriods(
                occupiedSessions.stream()
                        .map(session -> new TimePeriod(session.getTimeStart(), session.getTimeEnd()))
                        .collect(Collectors.toList())
        );

        List<TimePeriod> freeSlots = new ArrayList<>();
        LocalDateTime currentCheckTime = searchStart;

        while (currentCheckTime.plus(desiredSlotDuration).isBefore(searchEnd) ||
                currentCheckTime.plus(desiredSlotDuration).equals(searchEnd)) {

            LocalDateTime candidateEndTime = currentCheckTime.plus(desiredSlotDuration);
            boolean isFree = true;

            for (TimePeriod occupied : mergedOccupiedPeriods) {

                if (currentCheckTime.isBefore(occupied.getEndTime()) && candidateEndTime.isAfter(occupied.getStartTime())) {
                    isFree = false;
                    break;
                }
            }

            if (isFree) {
                freeSlots.add(new TimePeriod(currentCheckTime, candidateEndTime));
            }

            currentCheckTime = currentCheckTime.plus(checkGranularity);
        }

        return freeSlots;
    }


    private List<TimePeriod> mergeOverlappingPeriods(List<TimePeriod> periods) {
        if (periods == null || periods.isEmpty()) {
            return new ArrayList<>();
        }

        // Сортируем по времени начала
        periods.sort(Comparator.comparing(TimePeriod::getStartTime));

        List<TimePeriod> merged = new ArrayList<>();
        TimePeriod currentMerged = periods.get(0);

        for (int i = 1; i < periods.size(); i++) {
            TimePeriod next = periods.get(i);
            if (currentMerged.getEndTime().isAfter(next.getStartTime()) || currentMerged.getEndTime().equals(next.getStartTime())) {
                currentMerged.setEndTime(max(currentMerged.getEndTime(), next.getEndTime()));
            } else {
                merged.add(currentMerged);
                currentMerged = next;
            }
        }
        merged.add(currentMerged);

        return merged;
    }
    private LocalDateTime max(LocalDateTime dt1, LocalDateTime dt2) {
        return dt1.isAfter(dt2) ? dt1 : dt2;
    }

}
