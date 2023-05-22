package com.example.library_films_backend.controller;
import com.example.library_films_backend.model.FilmsItem;
import com.example.library_films_backend.repository.FilmsRepository;
import com.example.library_films_backend.service.FilmsService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/secure")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class FilmsController {
    private final FilmsService filmsService;

    @GetMapping(value = "/all-films")
    public List<FilmsItem> getAll() {
        List<FilmsItem> temp = filmsService.getAll();
        return temp;
    }

}
