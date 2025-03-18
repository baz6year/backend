package com.example.ArtGallery.service.Impl;

import com.example.ArtGallery.dto.UserRequest;
import com.example.ArtGallery.mapper.UserMapper;
import com.example.ArtGallery.model.User;
import com.example.ArtGallery.repository.UserRepository;
import com.example.ArtGallery.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public User getUserById(Long id) {
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

    }
}
