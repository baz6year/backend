package com.example.ArtGallery.service;

import com.example.ArtGallery.dto.UserRequest;
import com.example.ArtGallery.dto.UserResponse;
import com.example.ArtGallery.model.User;

import java.util.List;

public interface UserService {
    /* User getUserById(Long id);
    User createUser(UserRequest userRequest);
    User updateUser(UserRequest userRequest, Long id);
    void deleteUser(Long id); */
    UserResponse createUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();

    UserResponse getByEmail(String email);
}
