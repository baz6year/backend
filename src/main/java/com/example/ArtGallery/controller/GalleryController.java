package com.example.ArtGallery.controller;

import com.example.ArtGallery.model.Gallery;
import com.example.ArtGallery.service.GalleryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/gallery")
public class GalleryController {
    private final GalleryService galleryService;
    @GetMapping("/get")
    public Gallery getGallery(@PathVariable Long id) {
        return galleryService.getGallery(id);
    }
}
