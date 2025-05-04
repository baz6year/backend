package com.example.ArtGallery.mapper.Impl;

import com.example.ArtGallery.dto.AuthResponse;
import com.example.ArtGallery.dto.RegisterRequest;
import com.example.ArtGallery.mapper.AuthMapper;
import com.example.ArtGallery.model.User;
import com.example.ArtGallery.model.enums.Role;
import org.springframework.stereotype.Component;

@Component
public class AuthMapperImpl implements AuthMapper {
    @Override
    public User toUser(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.USER);
        return user;
    }
    @Override
    public AuthResponse toResponse(String token) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        return authResponse;
    }
}
