package com.example.library_films_backend.service;

import com.example.library_films_backend.dto.FilmsItemRequestDto;
import com.example.library_films_backend.dto.FilmsItemResponseDto;
import com.example.library_films_backend.jwt_controllers.AuthController;
import com.example.library_films_backend.model.FilmsItem;
import com.example.library_films_backend.model.StyleFilm;
import com.example.library_films_backend.repository.FilmsRepository;
import com.example.library_films_backend.repository.StyleFilmRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class FilmsService {
    private final FilmsRepository filmsRepository;
    private final StyleFilmRepository styleFilmRepository;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FilmsService.class);


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

    public void getByName(String name) {
        filmsRepository.getByName(name);
    }

    public void deleteByName(String name) {
        getByName(filmsRepository.deleteByName(name));

    }

    public void addNew(@Valid FilmsItemRequestDto filmsItemRequestDto) {
        StyleFilm findStyleFilm = styleFilmRepository.findById(filmsItemRequestDto.getStyleFilmId()).get();
        FilmsItem insertFilmsItem = FilmsItem.builder()
                .name(filmsItemRequestDto.getName())
                .releaseYear(filmsItemRequestDto.getReleaseYear())
                .description(filmsItemRequestDto.getDescription())
                .duration(filmsItemRequestDto.getDuration())
                .styleFilm(findStyleFilm)
                .build();
        filmsRepository.save(insertFilmsItem);
    }

}

