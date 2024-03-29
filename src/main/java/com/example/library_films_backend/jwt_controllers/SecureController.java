package com.example.library_films_backend.jwt_controllers;


import com.example.library_films_backend.dto.FilmsItemRequestDto;
import com.example.library_films_backend.dto.FilmsItemResponseDto;
import com.example.library_films_backend.service.FilmsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/secure")
public class SecureController {
    private final FilmsService filmsService;


    @GetMapping(value = "/all-films")
    public List<FilmsItemResponseDto> getAll() {
        return filmsService.getAll();
    }


    @PostMapping(value = "/add-films")
    public void addNew(@RequestBody FilmsItemRequestDto filmsItemRequestDto) {
        filmsService.addNew(filmsItemRequestDto);
    }


    @DeleteMapping(value = "/delete-films/{name}")
    public void deleteFilmsByName(@PathVariable String name) {
        filmsService.deleteByName(name);
    }


}
