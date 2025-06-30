package org.example.springsecurityrest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.dto.request.ChangePhotoStudioInfoRequest;
import org.example.springsecurityrest.dto.request.CreatePhotoStudioRequest;
import org.example.springsecurityrest.entity.UserEntity;
import org.example.springsecurityrest.service.AdminService;
import org.example.springsecurityrest.service.PhotoStudioService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    private final AdminService adminService;
    private final PhotoStudioService photoStudioService;

    @GetMapping()
    public String adminPage() {
        return "admin";
    }

    @PostAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users")
    public String usersPage(Model model) {
        List<UserEntity> users = adminService.findAllUsers();
        for (UserEntity user : users) {
            System.out.println(user);
        }
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/photoStudios")
    public String getPhotoStudios(Model model) {
        model.addAttribute("photoStudios", photoStudioService.getAllPhotoStudios());
        return "photoStudiosForAdmin";
    }

    @GetMapping("/photoStudios/create")
    public String getCreatePhotoStudioPage() {
        return "createPhotoStudioForAdmin";
    }

    @GetMapping("/photoStudios/update/{id}")
    public String getUpdatePhotoStudioPage(@PathVariable Long id, Model model) {
        model.addAttribute("photoStudio", photoStudioService.getPhotoStudioById(id));
        return "updatePhotoStudioForAdminPage";
    }

    @PostMapping("/photoStudios/update/{id}")
    public String updatePhotoStudioById(@PathVariable Long id,
                                        @Valid @ModelAttribute ChangePhotoStudioInfoRequest request,
                                        BindingResult result,
                                        Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getFieldErrors());
            model.addAttribute("photoStudio", photoStudioService.getPhotoStudioById(id));
            return "updatePhotoStudioForAdminPage";
        }
        photoStudioService.update(request);
        System.out.println(request.getAddress());
        return "redirect:/admin/photoStudios";
    }

    @GetMapping("/photoStudios/{id}")
    public String getPhotoStudio(Model model, @PathVariable Long id) {
        model.addAttribute("photoStudio", photoStudioService.getPhotoStudioById(id));
        model.addAttribute("photos", photoStudioService.getPhotosOfPhotoStudio(id));
        return "photoStudioForAdmin";
    }

    @DeleteMapping("/photoStudios/{photoStudioId}")
    public String deletePhotoStudio(@PathVariable Long photoStudioId) {
        photoStudioService.deletePhotoStudioById(photoStudioId);

        return "redirect:/admin/photoStudios";

    }


    @PostMapping("/photoStudios")
    public String addPhotoStudio(@Valid CreatePhotoStudioRequest request,
                                 BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getFieldErrors());
            return "createPhotoStudioForAdmin";
        }
        photoStudioService.save(request);
        System.out.println(request.getAddress());
        return "redirect:/admin/photoStudios";
    }

    @PostMapping(value = "/photoStudios/update/{photoStudioId}/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadPhotoForPhotoStudio(@PathVariable Long photoStudioId, @RequestParam("file") MultipartFile file) {
        photoStudioService.setPhotoOfPhotoStudio(photoStudioId, file);
        return "redirect:/admin/photoStudios";
    }


}