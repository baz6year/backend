package com.example.ArtGallery.service;

import com.example.ArtGallery.dto.UserRequest;
import com.example.ArtGallery.model.User;

public interface UserService {
    User getUserById(Long id);
    User createUser(UserRequest userRequest);
    User updateUser(UserRequest userRequest, Long id);
    void deleteUser(Long id);
}
