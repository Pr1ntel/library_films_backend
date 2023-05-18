package com.example.library_films_backend.repository;






import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmsRepository extends JpaRepository<FilmsItem, Integer> {
    List<FilmsItem> findAllByStyleFilm(String style);
    FilmsItem findFilmsItemById(int id);
    FilmsItem deleteById(int id);
}