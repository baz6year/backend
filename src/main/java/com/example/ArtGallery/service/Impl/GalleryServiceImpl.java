package com.example.ArtGallery.service.Impl;

import com.example.ArtGallery.mapper.GalleryMapper;
import com.example.ArtGallery.model.Gallery;
import com.example.ArtGallery.repository.GalleryRepository;
import com.example.ArtGallery.service.GalleryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GalleryServiceImpl implements GalleryService {
    private final GalleryRepository galleryRepository;
    private final GalleryMapper galleryMapper;


    @Override
    public Gallery getGallery(Long id) {
        return galleryRepository.findById(id).orElse(null);
    }
}
