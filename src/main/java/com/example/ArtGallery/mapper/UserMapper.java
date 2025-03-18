package com.example.ArtGallery.mapper;

import com.example.ArtGallery.dto.UserRequest;
import com.example.ArtGallery.dto.UserResponse;
import com.example.ArtGallery.model.User;

public interface UserMapper {
    User toUser(UserRequest userRequest);
    UserResponse toUserResponse(User user);
}
