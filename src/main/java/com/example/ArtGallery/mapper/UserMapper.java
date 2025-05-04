package com.example.ArtGallery.mapper;

import com.example.ArtGallery.dto.UserRequest;
import com.example.ArtGallery.dto.UserResponse;
import com.example.ArtGallery.model.User;

import java.util.List;

public interface UserMapper {
    User toUser(UserRequest userRequest);
    UserResponse toResponse(User user);
    List<UserResponse> toResponses(List<User> users);
}
