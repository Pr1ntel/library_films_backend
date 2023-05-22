package com.example.library_films_backend.jwt_controllers;

import com.example.library_films_backend.model.FilmsItem;
import com.example.library_films_backend.service.FilmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/secure")
public class SecureController {
    private final FilmsService filmsService;
    @GetMapping("/all-films")
        public List<FilmsItem> getAll() {
            return filmsService.getAll();
    }
}
