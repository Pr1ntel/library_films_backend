package com.example.library_films_backend.repository;

import com.example.library_films_backend.model.AddedFilms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddedFilmsRepository extends JpaRepository <AddedFilms, Integer> {

}
