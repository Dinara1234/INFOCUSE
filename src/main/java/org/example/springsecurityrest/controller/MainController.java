package org.example.springsecurityrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String welcomePage() {
        return "welcome";
    }


    @GetMapping("/user")
    public String userPage() {
        return "user";
    }


}