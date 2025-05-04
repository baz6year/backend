package com.example.ArtGallery.mapper;

import com.example.ArtGallery.dto.AuthResponse;
import com.example.ArtGallery.dto.RegisterRequest;
import com.example.ArtGallery.model.User;

public interface AuthMapper {
    User toUser(RegisterRequest request);
    AuthResponse toResponse(String token);
}
