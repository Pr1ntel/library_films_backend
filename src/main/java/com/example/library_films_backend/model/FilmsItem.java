package com.example.library_films_backend.model;


import jakarta.persistence.*;
import lombok.*;


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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "duration")
    private int duration;

    @Column(name = "photo")
    private String photo;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "style_film_id", nullable = false)
    private StyleFilm styleFilm;




}