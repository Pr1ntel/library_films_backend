package com.example.library_films_backend.auth_services;

import com.example.library_films_backend.dto.AuthOrRegisterResponseDto;
import com.example.library_films_backend.dto.AuthRequestDto;
import com.example.library_films_backend.dto.RegisterRequestDto;
import com.example.library_films_backend.model.User;
import com.example.library_films_backend.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthOrRegisterService {
    private final UsersRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthOrRegisterResponseDto register(RegisterRequestDto registerRequestDto) {
        User user = User.builder()
                .username(registerRequestDto.getUsername())
                .password(passwordEncoder.encode(registerRequestDto.getPassword()))
                .build();
        repository.save(user);

        String jwtToken = jwtService.generateToken(user);

        return AuthOrRegisterResponseDto.builder()
                .token(jwtToken)
                .build();

    }

    public AuthOrRegisterResponseDto auth(AuthRequestDto authRequestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDto.getUsername(),
                        authRequestDto.getPassword()
                )
        );

        User user = repository.findByUsername(authRequestDto.getUsername())
                .orElseThrow();

        String jwtToken = jwtService.generateToken(user);

        return AuthOrRegisterResponseDto.builder()
                .token(jwtToken)
                .build();

    }
}
