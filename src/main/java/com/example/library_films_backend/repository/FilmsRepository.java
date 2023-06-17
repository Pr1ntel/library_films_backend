package com.example.library_films_backend.repository;
import com.example.library_films_backend.model.FilmsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmsRepository extends JpaRepository<FilmsItem, Integer> {
    String deleteByName(String name);
    FilmsItem findByName(String name);

    FilmsItem getByName(String name);


}