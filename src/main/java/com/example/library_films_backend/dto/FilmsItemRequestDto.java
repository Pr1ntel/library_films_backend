package com.example.library_films_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilmsItemRequestDto {
    private String name;
    private String styleFilm;
    private int releaseYear;
    private String description;
    private int duration;
}
