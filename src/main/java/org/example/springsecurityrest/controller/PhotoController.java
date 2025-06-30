package org.example.springsecurityrest.controller;


import org.example.springsecurityrest.api.UnsplashPhoto;
import org.example.springsecurityrest.api.UnsplashSearchResponse;
import org.example.springsecurityrest.api.UnsplashService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/references")
public class PhotoController {

    private final UnsplashService unsplashService;

    public PhotoController(UnsplashService unsplashService) {
        this.unsplashService = unsplashService;
    }

    @GetMapping()
    public String getSearchPage() {
        return "references";
    }

    @GetMapping("/search-photos")
    public String searchPhotos(@RequestParam(value = "query", required = false, defaultValue = "nature") String query,
                               @RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "perPage", defaultValue = "10") int perPage,
                               Model model) {
        UnsplashSearchResponse response = unsplashService.searchPhotos(query, page+1, perPage);

        if (response != null && response.getResults() != null) {
            model.addAttribute("photos", response.getResults());
            model.addAttribute("query", query);
            model.addAttribute("totalResults", response.getTotal());
            model.addAttribute("page", page);
        } else {
            model.addAttribute("photos", Collections.emptyList());
            model.addAttribute("message", "No photos found or an error occurred. Check server logs.");
        }
        return "photos";
    }

    @GetMapping("/random-photo")
    public String getRandomPhoto(@RequestParam(value = "query", required = false) String query,
                                 Model model) {
        List<UnsplashPhoto> randomPhotos = unsplashService.getRandomPhotos(query);

        if (!randomPhotos.isEmpty()) {
            model.addAttribute("photo", randomPhotos.get(0));
        } else {
            model.addAttribute("message", "No random photo found or an error occurred. Check server logs.");
        }
        return "random-photo";
    }
}