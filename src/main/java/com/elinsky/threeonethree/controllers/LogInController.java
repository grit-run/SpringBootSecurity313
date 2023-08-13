package com.elinsky.threeonethree.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LogInController {
    @GetMapping("/login")
    public String loginForm() {
        return "/login";
    }
}
