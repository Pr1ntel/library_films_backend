package com.example.library_films_backend.service;

import com.example.library_films_backend.model.FilmsItem;
import com.example.library_films_backend.repository.FilmsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmsService {
    private final FilmsRepository filmsRepository;

    public List<FilmsItem> getAll(){
        return filmsRepository.findAll();
    }

    public FilmsItem findFilmByName(String name){
        return filmsRepository.findFilmsItemByNameFilm(name);
    }

}
