package com.example.library_films_backend.jwt_controllers;


import com.example.library_films_backend.dto.FilmsItemRequestDto;
import com.example.library_films_backend.dto.FilmsItemResponseDto;
import com.example.library_films_backend.jobs.JobsService;
import com.example.library_films_backend.model.FilmsItem;
import com.example.library_films_backend.service.FilmsService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/secure")
public class SecureController {
    private final FilmsService filmsService;
    private JobsService jobsService;

    @GetMapping(value = "/all-films")
    public List<FilmsItemResponseDto> getAll() {
        return filmsService.getAll();
    }

    @GetMapping(value = "/rekl")
    public void run() throws SchedulerException {
        jobsService.run();
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
