package com.example.library_films_backend.jwt_controllers;


import com.example.library_films_backend.dto.AuthOrRegisterResponseDto;
import com.example.library_films_backend.dto.AuthRequestDto;
import com.example.library_films_backend.dto.RegisterRequestDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthOrRegisterService authOrRegisterService;

    @PostMapping("/register")
    public AuthOrRegisterResponseDto register(@RequestBody RegisterRequestDto registerRequestDto){
        return authOrRegisterService.register(registerRequestDto);
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthOrRegisterResponseDto> auth(@RequestBody AuthRequestDto authRequestDto){
        return authOrRegisterService.auth(authRequestDto);
    }
}