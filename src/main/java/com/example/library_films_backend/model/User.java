package com.example.library_films_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name =  "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "token")
    private String token;
}
