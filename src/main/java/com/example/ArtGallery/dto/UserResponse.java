package com.example.ArtGallery.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String password;
    private String email;


}
