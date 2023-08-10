package com.example.library_films_backend.jwt_controllers;


import com.example.library_films_backend.auth_and_register_services.AuthOrRegisterService;
import com.example.library_films_backend.dto.AuthOrRegisterResponseDto;
import com.example.library_films_backend.dto.AuthRequestDto;
import com.example.library_films_backend.dto.RegisterRequestDto;
import com.example.library_films_backend.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthOrRegisterService authOrRegisterService;
    private final UsersRepository usersRepository;
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/register")
    public AuthOrRegisterResponseDto register(@RequestBody RegisterRequestDto registerRequestDto) {
        return authOrRegisterService.register(registerRequestDto);
    }

    @PostMapping("/authenticate")
    public AuthOrRegisterResponseDto auth(@RequestBody AuthRequestDto authRequestDto) {
        try {
            return authOrRegisterService.auth(authRequestDto);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("asd" + authRequestDto);
        }
        return null;
    }
}
