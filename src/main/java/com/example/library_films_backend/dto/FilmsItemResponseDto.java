package com.example.library_films_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilmsItemResponseDto {
    private int id;
    private String name;
    private String styleFilmName;
    private int releaseYear;
    private String description;
    private int duration;

}
