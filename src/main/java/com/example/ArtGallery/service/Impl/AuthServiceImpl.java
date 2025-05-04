package com.example.ArtGallery.service.Impl;

import com.example.ArtGallery.dto.AuthResponse;
import com.example.ArtGallery.dto.LoginRequest;
import com.example.ArtGallery.dto.RegisterRequest;
import com.example.ArtGallery.exception.CustomException;
import com.example.ArtGallery.mapper.AuthMapper;
import com.example.ArtGallery.model.User;
import com.example.ArtGallery.repository.UserRepository;
import com.example.ArtGallery.service.AuthService;
import com.example.ArtGallery.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthMapper authMapper;

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        User user = authMapper.toUser(registerRequest);
        user = userRepository.save(user);
        String token = jwtService.generateToken(user);
        return authMapper.toResponse(token);
    }
    @Override
    public AuthResponse login(LoginRequest loginRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword())
        );
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));
        String token = jwtService.generateToken(user);
        return authMapper.toResponse(token);

    }
}
