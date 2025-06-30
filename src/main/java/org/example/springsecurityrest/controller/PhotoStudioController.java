package org.example.springsecurityrest.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.dto.PhotoStudioDto;
import org.example.springsecurityrest.entity.TimePeriod;
import org.example.springsecurityrest.service.PhotoStudioService;
import org.example.springsecurityrest.service.impl.PhotoStudioAvailabilityService;
import org.example.springsecurityrest.service.impl.PhotographerAvailabilityService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class PhotoStudioController {
    private final PhotoStudioService photoStudioService;
    private final PhotoStudioAvailabilityService availabilityService;
    private final PhotographerAvailabilityService photographerAvailabilityService;



    @GetMapping("/user/photoStudios/{studioId}")
    public String getFreeSlots(
            Model model,
            @PathVariable Long studioId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime displayDate) {

        LocalDateTime actualDisplayDate;
        if (displayDate == null) {
            actualDisplayDate = LocalDate.now().atStartOfDay();
        } else {
            actualDisplayDate = displayDate.toLocalDate().atStartOfDay();
        }
        LocalDateTime searchStart = actualDisplayDate;
        LocalDateTime searchEnd = actualDisplayDate.plusDays(1).minusNanos(1);

        Duration desiredDuration = Duration.ofMinutes(90);
        Duration checkGranularity = Duration.ofMinutes(30);

        List<TimePeriod> freeSlots = availabilityService.findFreeTimeSlots(
                studioId, searchStart, searchEnd, desiredDuration, checkGranularity);

        model.addAttribute("photoStudio", photoStudioService.getPhotoStudioById(studioId));
        model.addAttribute("photos", photoStudioService.getPhotosOfPhotoStudio(studioId));
        model.addAttribute("studioId", studioId);
        model.addAttribute("freeSlots", freeSlots);
        model.addAttribute("currentSelectedDate", actualDisplayDate.toLocalDate());
        model.addAttribute("today", LocalDate.now());
        model.addAttribute("tomorrow", LocalDate.now().plusDays(1));
        model.addAttribute("dayAfterTomorrow", LocalDate.now().plusDays(2));

        return "photoStudioForAuth";
    }

    @GetMapping("/user/photoStudios/{studioId}/free-photographers")
    public String getFreePhotographers(Model model,
                                       @PathVariable Long studioId,
                                       @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
                                       @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime){
        PhotoStudioDto photoStudioDto = photoStudioService.getPhotoStudioById(studioId);
        model.addAttribute("studioId", studioId);
        model.addAttribute("studio", photoStudioDto);
        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        model.addAttribute("photographers", photographerAvailabilityService.findAvailablePhotographers(startTime, endTime));
        return "free-photographers";

    }


    @GetMapping("/photoStudios")
    public String getPhotoStudioList(Model model) {
        model.addAttribute("photoStudios", photoStudioService.getAllPhotoStudios());
        return "photoStudios";
    }

    @GetMapping("/photoStudios/{id}")
    public String getPhotoStudio(Model model, @PathVariable Long id) {
        model.addAttribute("photoStudio", photoStudioService.getPhotoStudioById(id));
        model.addAttribute("photos", photoStudioService.getPhotosOfPhotoStudio(id));
        return "photoStudio";
    }
    @GetMapping("/user/photoStudios")
    public String getPhotoStudioListForAuth(Model model) {
        model.addAttribute("photoStudios", photoStudioService.getAllPhotoStudios());
        return "photoStudiosForAuth";
    }





}
