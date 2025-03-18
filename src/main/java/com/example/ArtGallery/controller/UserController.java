package com.example.ArtGallery.controller;

import com.example.ArtGallery.dto.UserRequest;
import com.example.ArtGallery.model.User;
import com.example.ArtGallery.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/get/{id}")
    public User getUserById(@RequestParam("id") Long id) {
        return userService.getUserById(id);
    }
    @PostMapping("/create")
    public User createUser(UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
    @PutMapping("/update/{id}")
    public User updateUser(UserRequest userRequest, @PathVariable Long id) {
        return userService.updateUser(userRequest, id);
    }
    @DeleteMapping("/delete")
    public void deleteUser(Long id){
        userService.deleteUser(id);
    }
}
