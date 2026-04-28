package org.example.springsecurityrest.controller;

import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.service.PhotographerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {
    private final PhotographerService photographerService;

    @GetMapping
    public String welcomePage() {
        return "welcome";
    }


    @GetMapping("/user")
    public String userPage() {
        return "user";
    }

    @GetMapping("/user/portfolios")
    public String getPhotoStudioList(Model model) {
        model.addAttribute("photographers", photographerService.getAllPhotographers());
        return "portfolios";
    }

    @GetMapping("/user/portfolios/{id}")
    public String getPhotoStudio(Model model, @PathVariable Long id) {
        model.addAttribute("photographer", photographerService.getPhotographerById(id));

        return "portfolioOfPhotographerForUser";
    }


}