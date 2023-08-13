package com.elinsky.threeonethree.controllers;

import com.elinsky.threeonethree.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;

@Controller
@RequestMapping("/")
public class WelcomeController {

    private final UserDetailsServiceImpl userDetailsService;

    public WelcomeController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @GetMapping("/")
    public String start() {
        return "/index";
    }



    @GetMapping("/user")
    public String pageForUserProfile(Model model, Principal principal) {
        model.addAttribute("user", userDetailsService.findByName(principal.getName()));

        return "user";
    }
}