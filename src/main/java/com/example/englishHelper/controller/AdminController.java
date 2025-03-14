package com.example.englishHelper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AdminController {

    @GetMapping("/admin")
    public String adminPage(){

        return "admin page";
    }
}
