package com.example.library_films_backend.service;

import com.example.library_films_backend.dto.FilmsItemResponseDto;
import com.example.library_films_backend.model.FilmsItem;
import com.example.library_films_backend.repository.FilmsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilmsService {
    private final FilmsRepository filmsRepository;

    public List<FilmsItemResponseDto> getAll() {
        return filmsRepository.findAll().stream().map(
                filmsItem -> FilmsItemResponseDto.builder()
                        .id(filmsItem.getId())
                        .name(filmsItem.getName())
                        .styleFilmName(filmsItem.getStyleFilm().getName())
                        .releaseYear(filmsItem.getReleaseYear())
                        .description(filmsItem.getDescription())
                        .duration(filmsItem.getDuration())
                        .build()
        ).collect(Collectors.toList());

    }

    public FilmsItem findFilmByName(String name) {
        return filmsRepository.findFilmsItemByName(name);
    }

}

