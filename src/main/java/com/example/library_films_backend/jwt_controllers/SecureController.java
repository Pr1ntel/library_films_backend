package com.example.library_films_backend.jwt_controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/secure")
public class SecureController {

    @GetMapping("/home")
    public String getHello() {
        return "hello secure";
    }
}
