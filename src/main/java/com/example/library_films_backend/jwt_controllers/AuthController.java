package com.example.library_films_backend.jwt_controllers;


import com.example.library_films_backend.auth_and_register_services.AuthOrRegisterService;
import com.example.library_films_backend.dto.AuthOrRegisterResponseDto;
import com.example.library_films_backend.dto.AuthRequestDto;
import com.example.library_films_backend.dto.RegisterRequestDto;
import com.example.library_films_backend.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthOrRegisterService authOrRegisterService;
    private final UsersRepository usersRepository;

    @PostMapping("/register")
    public AuthOrRegisterResponseDto register(@RequestBody RegisterRequestDto registerRequestDto){
        return authOrRegisterService.register(registerRequestDto);
    }

    @PostMapping("/authenticate")
    public AuthOrRegisterResponseDto auth(@RequestBody AuthRequestDto authRequestDto){
        return authOrRegisterService.auth(authRequestDto);
    }
}
