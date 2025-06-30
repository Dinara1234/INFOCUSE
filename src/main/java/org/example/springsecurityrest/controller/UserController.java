package org.example.springsecurityrest.controller;

import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.dto.PhotoSessionDto;
import org.example.springsecurityrest.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private  final UserService userService;
    @GetMapping("/photoSessions")
    public String getPhotoSessionsOfUser(Authentication authentication, Model model) {
        Set<PhotoSessionDto> photoSessions = userService.getAllUsersPhotosessions(authentication);
        model.addAttribute("photoSessions", photoSessions);
        return "userPhotoSessions";
    }
}
