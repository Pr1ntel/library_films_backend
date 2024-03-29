package com.example.library_films_backend.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestDto {
    @NotNull @Min(5) @Max(64)
    private String username;
    @NotNull @Min(5) @Max(70)
    private String password;
}
