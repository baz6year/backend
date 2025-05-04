package com.example.ArtGallery.service.Impl;

import com.example.ArtGallery.dto.UserRequest;
import com.example.ArtGallery.dto.UserResponse;
import com.example.ArtGallery.exception.CustomException;
import com.example.ArtGallery.mapper.UserMapper;
import com.example.ArtGallery.model.User;
import com.example.ArtGallery.repository.UserRepository;
import com.example.ArtGallery.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    /* public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(UserRequest userRequest) {
        return userRepository.save(userMapper.toUser(userRequest));
    }

    @Override
    public User updateUser(UserRequest userRequest, Long id) {
        User user = userRepository.findById(id).orElse(null);
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        return userRepository.save(user);

    }

    @Override
    public void deleteUser(Long id) {

    } */
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        user = userRepository.save(user);
        return userMapper.toResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toResponses(users);
    }

    @Override
    public UserResponse getByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new CustomException("Coudn`t find this email", HttpStatus.NOT_FOUND));
        return userMapper.toResponse(user);
    }
}
