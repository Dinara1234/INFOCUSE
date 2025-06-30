package org.example.springsecurityrest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.dto.PhotographerDetailsDto;
import org.example.springsecurityrest.dto.UserDto;
import org.example.springsecurityrest.dto.request.UpdatePhotographerInfoRequest;
import org.example.springsecurityrest.entity.Photo;
import org.example.springsecurityrest.repository.PhotoSessionRepository;
import org.example.springsecurityrest.repository.UserRepository;
import org.example.springsecurityrest.service.PhotographerService;
import org.example.springsecurityrest.service.UserService;
import org.example.springsecurityrest.service.impl.PhotoSessionServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Controller
@RequestMapping("/photographer")
@RequiredArgsConstructor
public class PhotographerController {
    private final PhotographerService photographerService;
    private final UserService userService;
    private final PhotoSessionServiceImpl photoSessionServiceImpl;

    @GetMapping()
    public String photographerPage(Authentication auth, Model model) {
        UserDto user = userService.getUserFromAuthentication(auth);
        PhotographerDetailsDto details = photographerService.getPhotographerDetails(auth);
        Set<Photo> photos = photographerService.photosOfPhotographer(auth);
        model.addAttribute("photos", photos);
        model.addAttribute("photographer", user);
        model.addAttribute("photographerDetails", details);
        return "photographer";
    }

    @GetMapping("/update")
    public String getUpdatePage(Authentication auth, Model model) {
        UserDto user = userService.getUserFromAuthentication(auth);
        PhotographerDetailsDto details = photographerService.getPhotographerDetails(auth);
        model.addAttribute("photographer", user);
        model.addAttribute("photographerDetails", details);
        return "photographerUpdate";
    }

    @PostMapping("/update")
    public String updatePhotographerInfo(Authentication auth,
                                         @Valid  UpdatePhotographerInfoRequest request,
                                         Model model,
                                         BindingResult result) {

        if (result.hasErrors()) {
            UserDto user = userService.getUserFromAuthentication(auth);
            PhotographerDetailsDto details = photographerService.getPhotographerDetails(auth);
            model.addAttribute("photographer", user);
            model.addAttribute("photographerDetails", details);
            model.addAttribute("errors", result.getFieldErrors());
            return "photographerUpdate";
        }

        photographerService.updateInformation(auth, request);
        return "redirect:/photographer";
    }

    @PostMapping("/update/upload")
    public String uploadPhoto(Authentication auth, MultipartFile file) {
        photographerService.setPhotoOfPhotographerByAuth(auth, file);
        return "redirect:/photographer";
    }

    @GetMapping("/allPhotoSessions")
    public String allPhotoSessionsPage(Authentication auth, Model model) {
       model.addAttribute("photoSessions", photoSessionServiceImpl.getPhotoSessionsByPhotographer(auth));
       return "photoSessionsOfPhotographer";
    }
}
