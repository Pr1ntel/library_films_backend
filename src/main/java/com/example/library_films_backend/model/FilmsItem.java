package com.example.library_films_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name =  "films")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilmsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_film")
    private String nameFilm;

    @Column(name = "release_date")
    private int releaseDate;

    @Column(name = "duration_film")
    private int durationFilm;

    @Column(name = "photo_film")
    private String photoFilm;

    @Column(name = "description_film")
    private String descriptionFilm;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "style_film_id")
    private StyleFilm styleFilmId;
}
