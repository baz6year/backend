package com.example.ArtGallery.dto;

import lombok.Data;

@Data
public class GalleryResponse {
    private Long id;
    private String name;
    private String description;
    private String address;
}
