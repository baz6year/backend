package com.example.ArtGallery.service.Impl;

import com.example.ArtGallery.model.Gallery;
import com.example.ArtGallery.service.GalleryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GalleryServiceImpl implements GalleryService {
    @Override
    public Gallery getGalleryName(String name) {
        return null;
    }

    @Override
    public Gallery getGalleryDescription(String description) {
        return null;
    }
}
