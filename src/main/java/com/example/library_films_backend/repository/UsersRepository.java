package com.example.library_films_backend.repository;

import com.example.library_films_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository  extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
