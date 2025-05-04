package com.example.ArtGallery.service;

import com.example.ArtGallery.dto.AuthResponse;
import com.example.ArtGallery.dto.LoginRequest;
import com.example.ArtGallery.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse login(LoginRequest loginRequest);
}
