package com.example.ArtGallery.service;

import com.example.ArtGallery.model.Gallery;

public interface GalleryService {
    Gallery getGalleryName(String name);
    Gallery getGalleryDescription(String description);
}
