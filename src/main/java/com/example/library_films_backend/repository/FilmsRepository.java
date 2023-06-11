package com.example.library_films_backend.repository;
import com.example.library_films_backend.model.FilmsItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface FilmsRepository extends JpaRepository<FilmsItem, Integer> {
    List<FilmsItem> findAllByStyleFilmId(int id);
    FilmsItem findFilmsItemByName(String name);
    FilmsItem deleteFilmByName(String name);

}