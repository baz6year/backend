package com.example.ArtGallery.mapper.Impl;

import com.example.ArtGallery.dto.GalleryResponse;
import com.example.ArtGallery.dto.UserRequest;
import com.example.ArtGallery.dto.UserResponse;
import com.example.ArtGallery.mapper.UserMapper;
import com.example.ArtGallery.model.Gallery;
import com.example.ArtGallery.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User toUser(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        return user;
    }

    @Override
    public UserResponse toUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getUsername());
        userResponse.setPassword(user.getPassword());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }
}
