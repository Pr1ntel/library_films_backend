package com.example.library_films_backend;


import com.example.library_films_backend.model.FilmsItem;
import com.example.library_films_backend.model.StyleFilm;
import com.example.library_films_backend.repository.FilmsRepository;
import com.example.library_films_backend.repository.StyleFilmRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FilmsItemTest {
    FilmsRepository filmsRepository = Mockito.mock(FilmsRepository.class);
    StyleFilmRepository styleFilmRepository = Mockito.mock(StyleFilmRepository.class);
    StyleFilm styleFilm = Mockito.mock(StyleFilm.class);

    @Test
    void testFindFilmsItemByName() {
        FilmsItem MockItem = filmsRepository.getByName("asd");


        when(filmsRepository.getByName("Астрал")).thenReturn(
                new FilmsItem(
                        19,
                        "Астра",
                        2010,
                        103,
                        "sad",
                        "asd",
                        styleFilm
                ));

     /*   FilmsItem expectedFilm = filmsRepository.getByName("Астрал") =
                new FilmsItem(
                        19,
                        "Астра",
                        2010,
                        103,
                        "sad",
                        "asd",
                        styleFilm
                );
        FilmsItem actualFilm = filmsRepository.getByName("Астрал");*/
    }

    @Test
    void deleteFilmsItemByName() {
        filmsRepository.deleteByName("Астрал");
        verify(filmsRepository).deleteByName("Астрал");
    }

    @Test
    void addedNewFilmsItem() {
        filmsRepository.save(new FilmsItem( 19,
                "Астра",
                2010,
                103,
                "sad",
                "asd",
                styleFilm));
        filmsRepository.flush();
    }
}
