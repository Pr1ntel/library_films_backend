package com.example.library_films_backend.service;

import com.example.library_films_backend.dto.FilmsItemRequestDto;
import com.example.library_films_backend.dto.FilmsItemResponseDto;
import com.example.library_films_backend.model.FilmsItem;
import com.example.library_films_backend.model.StyleFilm;
import com.example.library_films_backend.repository.FilmsRepository;
import com.example.library_films_backend.repository.StyleFilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilmsService {
    private final FilmsRepository filmsRepository;
    private final StyleFilmRepository styleFilmRepository;

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



    public FilmsItem deleteByName(String name){
        return filmsRepository.deleteFilmByName(name);
    }

public void addNew(FilmsItemRequestDto filmsItemRequestDto){
    StyleFilm findStyleFilm = styleFilmRepository.findById(filmsItemRequestDto.getStyleFilmId()).get();
    FilmsItem insertFilmsItem = FilmsItem.builder()
            .name(filmsItemRequestDto.getName())
            .releaseYear(filmsItemRequestDto.getReleaseYear())
            .description(filmsItemRequestDto.getDescription())
            .duration(filmsItemRequestDto.getDuration())
            .styleFilm(findStyleFilm)
            .build();
    filmsRepository .save(insertFilmsItem);
}

}

