package com.example.library_films_backend.service;

import com.example.library_films_backend.model.User;
import com.example.library_films_backend.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;


    public User getUserById(int userId){
        return usersRepository.getById(userId);
    }

}
