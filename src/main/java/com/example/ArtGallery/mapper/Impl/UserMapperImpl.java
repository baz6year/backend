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

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User toUser(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setAge(request.getAge());
        return user;
    }

    @Override
    public UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setAge(user.getAge());
        return userResponse;
    }

    @Override
    public List<UserResponse> toResponses(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<>();

        for (User user : users) {
            userResponses.add(toResponse(user));
        }

        return userResponses;
    }
}
