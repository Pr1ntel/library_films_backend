package com.example.library_films_backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FilmsItemRequestDto {
    @Min(1) @Max(30) @NotNull
    private String name;
    @Min(1) @Max(6) @NotNull
    private int styleFilmId;
    @Min(0)
    private int releaseYear;
    private String description;
    private int duration;
}
