package com.example.library_films_backend.model;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "style_film")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StyleFilm {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId(int id) {
        return id;
    }

    @Column(name = "name")
    private String name;

}
