package org.example.springsecurityrest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.dto.request.SignUpRequest;
import org.example.springsecurityrest.service.SignUpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor
@Controller
public class AuthController {

    private final SignUpService signUpService;

    @GetMapping("/sign-in")
    public String signInPage() {
        return "signIn";
    }

    @GetMapping("/sign-up")
    public String signUpPage() {
        return "signUp";
    }

    @PostMapping("/sign-up")
    public String signUp(@Valid SignUpRequest signUpRequest,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getFieldErrors());
            return "signUp";
        }
        if(signUpService.signUp(signUpRequest)) {
            if(signUpRequest.getRole().equals("Пользователь")){
                return "redirect:/profile";
            }
            if(signUpRequest.getRole().equals("Фотограф")){
                return "redirect:/photographer";
            }
            return "redirect:/sign-in";
        }

        return "redirect:/sign-up?error=1";
    }



}

