package com.example.library_films_backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "films")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilmsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "duration")
    private int duration;

    @Column(name = "photo")
    private String photo;

    @Column(name = "description")
    private String description;
    /* @JsonIgnore*/
    @ManyToOne
    @JoinColumn(name = "style_film_id")
    private StyleFilm styleFilm;
}