package com.example.library_films_backend.repository;

import com.example.library_films_backend.model.StyleFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleFilmRepository extends JpaRepository<StyleFilm, Integer> {
}
