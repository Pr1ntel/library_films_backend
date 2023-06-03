package com.example.library_films_backend.repository;

import com.example.library_films_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsersRepository  extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
