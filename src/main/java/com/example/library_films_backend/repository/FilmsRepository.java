package com.example.library_films_backend.repository;
import com.example.library_films_backend.model.FilmsItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmsRepository extends JpaRepository<FilmsItem, Integer> {
    FilmsItem deleteFilmByName(String name);

}