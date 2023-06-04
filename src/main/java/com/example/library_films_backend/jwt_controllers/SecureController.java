package com.example.library_films_backend.jwt_controllers;

import com.example.library_films_backend.dto.FilmsItemResponseDto;
import com.example.library_films_backend.jobs.JobsService;
import com.example.library_films_backend.model.FilmsItem;
import com.example.library_films_backend.service.FilmsService;
import lombok.AllArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
